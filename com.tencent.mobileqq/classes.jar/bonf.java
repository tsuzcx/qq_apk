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

public class bonf
  extends bowm
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bofh jdField_a_of_type_Bofh;
  private bonn jdField_a_of_type_Bonn;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bonn jdField_b_of_type_Bonn;
  private RecyclerView jdField_c_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private bonn jdField_c_of_type_Bonn;
  private RecyclerView jdField_d_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_d_of_type_AndroidWidgetCheckBox;
  private bonn jdField_d_of_type_Bonn;
  
  public bonf(Activity paramActivity, View paramView, bown parambown)
  {
    super(paramActivity, paramView, parambown);
    this.jdField_a_of_type_Bofh = ((bofh)parambown.a(65537, new Object[0]));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bonh(this));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new boni(this));
    this.jdField_c_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bonj(this));
    this.jdField_d_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bonk(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bonn = new bonn(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_Bonn = new bonn(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_Bonn = new bonn(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_d_of_type_Bonn = new bonn(this.jdField_a_of_type_AndroidAppActivity);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bonn);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_b_of_type_Bonn);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_c_of_type_Bonn);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_d_of_type_Bonn);
  }
  
  private void f()
  {
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_GET_ENV_INFO", null, new bonl(this));
  }
  
  private void h()
  {
    bomz.a().observe(this.jdField_a_of_type_Bofh, new bonm(this));
  }
  
  protected void a()
  {
    View localView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362242)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362247));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362248));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362245));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362250));
    this.jdField_c_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362253));
    this.jdField_d_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362252));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362244));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362249));
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362243));
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362251));
    b();
    e();
    f();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bong(this));
    h();
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
        localObject3 = (bonc)((Iterator)localObject2).next();
        localbonp = new bonp(null);
        localbonp.a = bonr.a((bonc)localObject3);
        paramVarArgs.add(localbonp);
      }
      localObject2 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (bonb)((Iterator)localObject1).next();
        localbonp = new bonp(null);
        localbonp.a = ((bonb)localObject3).toString();
        ((List)localObject2).add(localbonp);
      }
      this.jdField_a_of_type_Bonn.a(paramVarArgs);
      this.jdField_c_of_type_Bonn.a((List)localObject2);
    }
    while ((paramInt != 720898) || (this.jdField_d_of_type_Bonn == null))
    {
      bonp localbonp;
      return;
    }
    Object localObject1 = bomz.a.a();
    paramVarArgs = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new bonp(null);
      ((bonp)localObject3).a = ((CharSequence)localObject2);
      paramVarArgs.add(localObject3);
    }
    this.jdField_d_of_type_Bonn.a(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bonf
 * JD-Core Version:    0.7.0.1
 */