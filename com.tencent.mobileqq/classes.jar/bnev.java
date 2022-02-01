import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bnev
  extends bnqb
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmxa jdField_a_of_type_Bmxa;
  private bnfd jdField_a_of_type_Bnfd;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bnfd jdField_b_of_type_Bnfd;
  private RecyclerView jdField_c_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private bnfd jdField_c_of_type_Bnfd;
  private RecyclerView jdField_d_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_d_of_type_AndroidWidgetCheckBox;
  private bnfd jdField_d_of_type_Bnfd;
  
  public bnev(Activity paramActivity, View paramView, bnqc parambnqc)
  {
    super(paramActivity, paramView, parambnqc);
    this.jdField_a_of_type_Bmxa = ((bmxa)parambnqc.a(65537, new Object[0]));
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bnex(this));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bney(this));
    this.jdField_c_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bnez(this));
    this.jdField_d_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bnfa(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bnfd = new bnfd(this.mActivity);
    this.jdField_b_of_type_Bnfd = new bnfd(this.mActivity);
    this.jdField_c_of_type_Bnfd = new bnfd(this.mActivity);
    this.jdField_d_of_type_Bnfd = new bnfd(this.mActivity);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bnfd);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_b_of_type_Bnfd);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_c_of_type_Bnfd);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_d_of_type_Bnfd);
  }
  
  private void c()
  {
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_GET_ENV_INFO", null, new bnfb(this));
  }
  
  private void d()
  {
    bnep.a().observe(this.jdField_a_of_type_Bmxa, new bnfc(this));
  }
  
  protected void initView()
  {
    View localView = ((ViewStub)this.mRootView.findViewById(2131362245)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362250));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362251));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362248));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362253));
    this.jdField_c_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362256));
    this.jdField_d_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362255));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362247));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362252));
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362246));
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362254));
    a();
    b();
    c();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bnew(this));
    d();
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    Object localObject2;
    Object localObject3;
    if (paramInt == 720897)
    {
      localObject2 = (List)paramVarArgs[0];
      localObject1 = (List)paramVarArgs[1];
      paramVarArgs = new LinkedList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bnes)((Iterator)localObject2).next();
        localbnff = new bnff(null);
        localbnff.a = bnfh.a((bnes)localObject3);
        paramVarArgs.add(localbnff);
      }
      localObject2 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (bner)((Iterator)localObject1).next();
        localbnff = new bnff(null);
        localbnff.a = ((bner)localObject3).toString();
        ((List)localObject2).add(localbnff);
      }
      this.jdField_a_of_type_Bnfd.a(paramVarArgs);
      this.jdField_c_of_type_Bnfd.a((List)localObject2);
    }
    while ((paramInt != 720898) || (this.jdField_d_of_type_Bnfd == null))
    {
      bnff localbnff;
      return;
    }
    Object localObject1 = bnep.a.a();
    paramVarArgs = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new bnff(null);
      ((bnff)localObject3).a = ((CharSequence)localObject2);
      paramVarArgs.add(localObject3);
    }
    this.jdField_d_of_type_Bnfd.a(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnev
 * JD-Core Version:    0.7.0.1
 */