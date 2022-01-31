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

public class bksk
  extends blbl
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkle jdField_a_of_type_Bkle;
  private bkss jdField_a_of_type_Bkss;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bkss jdField_b_of_type_Bkss;
  private RecyclerView jdField_c_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private bkss jdField_c_of_type_Bkss;
  private RecyclerView jdField_d_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_d_of_type_AndroidWidgetCheckBox;
  private bkss jdField_d_of_type_Bkss;
  
  public bksk(Activity paramActivity, View paramView, blbm paramblbm)
  {
    super(paramActivity, paramView, paramblbm);
    this.jdField_a_of_type_Bkle = ((bkle)paramblbm.a(65537, new Object[0]));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bksm(this));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bksn(this));
    this.jdField_c_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bkso(this));
    this.jdField_d_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bksp(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bkss = new bkss(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_Bkss = new bkss(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_Bkss = new bkss(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_d_of_type_Bkss = new bkss(this.jdField_a_of_type_AndroidAppActivity);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bkss);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_b_of_type_Bkss);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_c_of_type_Bkss);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_d_of_type_Bkss);
  }
  
  private void f()
  {
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_GET_ENV_INFO", null, new bksq(this));
  }
  
  private void k()
  {
    bkse.a().a(this.jdField_a_of_type_Bkle, new bksr(this));
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
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bksl(this));
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
        localObject3 = (bksh)((Iterator)localObject2).next();
        localbksu = new bksu(null);
        localbksu.a = bksw.a((bksh)localObject3);
        paramVarArgs.add(localbksu);
      }
      localObject2 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (bksg)((Iterator)localObject1).next();
        localbksu = new bksu(null);
        localbksu.a = ((bksg)localObject3).toString();
        ((List)localObject2).add(localbksu);
      }
      this.jdField_a_of_type_Bkss.a(paramVarArgs);
      this.jdField_c_of_type_Bkss.a((List)localObject2);
    }
    while ((paramInt != 720898) || (this.jdField_d_of_type_Bkss == null))
    {
      bksu localbksu;
      return;
    }
    Object localObject1 = bkse.a.a();
    paramVarArgs = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new bksu(null);
      ((bksu)localObject3).a = ((CharSequence)localObject2);
      paramVarArgs.add(localObject3);
    }
    this.jdField_d_of_type_Bkss.a(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksk
 * JD-Core Version:    0.7.0.1
 */