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

public class binq
  extends biwr
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bijd jdField_a_of_type_Bijd;
  private biny jdField_a_of_type_Biny;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private biny jdField_b_of_type_Biny;
  private RecyclerView jdField_c_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private biny jdField_c_of_type_Biny;
  private RecyclerView jdField_d_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_d_of_type_AndroidWidgetCheckBox;
  private biny jdField_d_of_type_Biny;
  
  public binq(Activity paramActivity, View paramView, biws parambiws)
  {
    super(paramActivity, paramView, parambiws);
    this.jdField_a_of_type_Bijd = ((bijd)parambiws.a(65537, new Object[0]));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bins(this));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bint(this));
    this.jdField_c_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new binu(this));
    this.jdField_d_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new binv(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Biny = new biny(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_Biny = new biny(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_Biny = new biny(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_d_of_type_Biny = new biny(this.jdField_a_of_type_AndroidAppActivity);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Biny);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_b_of_type_Biny);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_c_of_type_Biny);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_d_of_type_Biny);
  }
  
  private void f()
  {
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_GET_ENV_INFO", null, new binw(this));
  }
  
  private void k()
  {
    bink.a().a(this.jdField_a_of_type_Bijd, new binx(this));
  }
  
  protected void a()
  {
    View localView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362153)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362158));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362159));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362156));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362161));
    this.jdField_c_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362164));
    this.jdField_d_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362163));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362155));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362160));
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362154));
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362162));
    d();
    e();
    f();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new binr(this));
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
        localObject3 = (binn)((Iterator)localObject2).next();
        localbioa = new bioa(null);
        localbioa.a = bioc.a((binn)localObject3);
        paramVarArgs.add(localbioa);
      }
      localObject2 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (binm)((Iterator)localObject1).next();
        localbioa = new bioa(null);
        localbioa.a = ((binm)localObject3).toString();
        ((List)localObject2).add(localbioa);
      }
      this.jdField_a_of_type_Biny.a(paramVarArgs);
      this.jdField_c_of_type_Biny.a((List)localObject2);
    }
    while ((paramInt != 720898) || (this.jdField_d_of_type_Biny == null))
    {
      bioa localbioa;
      return;
    }
    Object localObject1 = bink.a.a();
    paramVarArgs = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new bioa(null);
      ((bioa)localObject3).a = ((CharSequence)localObject2);
      paramVarArgs.add(localObject3);
    }
    this.jdField_d_of_type_Biny.a(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     binq
 * JD-Core Version:    0.7.0.1
 */