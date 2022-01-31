import android.app.Activity;
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

public class bkwr
  extends blfs
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkpl jdField_a_of_type_Bkpl;
  private bkwz jdField_a_of_type_Bkwz;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bkwz jdField_b_of_type_Bkwz;
  private RecyclerView jdField_c_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private bkwz jdField_c_of_type_Bkwz;
  private RecyclerView jdField_d_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_d_of_type_AndroidWidgetCheckBox;
  private bkwz jdField_d_of_type_Bkwz;
  
  public bkwr(Activity paramActivity, View paramView, blft paramblft)
  {
    super(paramActivity, paramView, paramblft);
    this.jdField_a_of_type_Bkpl = ((bkpl)paramblft.a(65537, new Object[0]));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bkwt(this));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bkwu(this));
    this.jdField_c_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bkwv(this));
    this.jdField_d_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bkww(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bkwz = new bkwz(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_Bkwz = new bkwz(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_Bkwz = new bkwz(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_d_of_type_Bkwz = new bkwz(this.jdField_a_of_type_AndroidAppActivity);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bkwz);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_b_of_type_Bkwz);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_c_of_type_Bkwz);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_d_of_type_Bkwz);
  }
  
  private void f()
  {
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_GET_ENV_INFO", null, new bkwx(this));
  }
  
  private void k()
  {
    bkwl.a().a(this.jdField_a_of_type_Bkpl, new bkwy(this));
  }
  
  protected void a()
  {
    View localView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362161)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362166));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362167));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362164));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362169));
    this.jdField_c_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362172));
    this.jdField_d_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362171));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362163));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362168));
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362162));
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362170));
    d();
    e();
    f();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bkws(this));
    k();
  }
  
  public void a(int paramInt, Object... paramVarArgs)
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
        localObject3 = (bkwo)((Iterator)localObject2).next();
        localbkxb = new bkxb(null);
        localbkxb.a = bkxd.a((bkwo)localObject3);
        paramVarArgs.add(localbkxb);
      }
      localObject2 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (bkwn)((Iterator)localObject1).next();
        localbkxb = new bkxb(null);
        localbkxb.a = ((bkwn)localObject3).toString();
        ((List)localObject2).add(localbkxb);
      }
      this.jdField_a_of_type_Bkwz.a(paramVarArgs);
      this.jdField_c_of_type_Bkwz.a((List)localObject2);
    }
    while ((paramInt != 720898) || (this.jdField_d_of_type_Bkwz == null))
    {
      bkxb localbkxb;
      return;
    }
    Object localObject1 = bkwl.a.a();
    paramVarArgs = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new bkxb(null);
      ((bkxb)localObject3).a = ((CharSequence)localObject2);
      paramVarArgs.add(localObject3);
    }
    this.jdField_d_of_type_Bkwz.a(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwr
 * JD-Core Version:    0.7.0.1
 */