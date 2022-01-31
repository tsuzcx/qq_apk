import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.ShareUtils.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class axip
  implements AdapterView.OnItemClickListener
{
  private float jdField_a_of_type_Float = 1.0F;
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private axit jdField_a_of_type_Axit;
  private begr jdField_a_of_type_Begr;
  private ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected String a;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private ElasticHorScrView jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView;
  protected String b;
  protected String c;
  protected String d;
  
  public axip(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
  }
  
  @SuppressLint({"InflateParams"})
  @TargetApi(9)
  protected View a()
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131493481, null);
    localView.setBackgroundResource(2130838503);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131309901));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131309902));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296392));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131654269);
    Object localObject1;
    GridView localGridView2;
    GridView localGridView1;
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = (LinearLayout)localView.findViewById(2131296395);
      if ((localObject1 != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
        ((LinearLayout)localObject1).addView(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int);
      }
      localGridView2 = (GridView)localView.findViewById(2131301556);
      localGridView1 = (GridView)localView.findViewById(2131301557);
      localObject1 = (TextView)localView.findViewById(2131296391);
      ((TextView)localObject1).setTextColor(-16777216);
      ((TextView)localObject1).setText(2131625035);
      ((TextView)localObject1).setOnClickListener(new axiq(this));
      if (Build.VERSION.SDK_INT >= 9)
      {
        this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
        this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      localGridView1.setSmoothScrollbarEnabled(false);
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label458;
      }
      localObject1 = localObject2[0];
      label228:
      if (localObject2.length <= 1) {
        break label470;
      }
    }
    label458:
    label470:
    for (Object localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int i = ((List)localObject1).size();
      localGridView2.setNumColumns(i);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((i - 1) * 10 + i * 75 + 3) * this.jdField_a_of_type_Float));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new ncc(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i = localLayoutParams.width;
      int j = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((j * 75 + (j - 1) * 10 + 3) * this.jdField_a_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(j);
      localGridView1.setAdapter(new ncc(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new ShareUtils.2(this, i, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      localObject1 = new ArrayList(0);
      break label228;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Begr == null)
      {
        this.jdField_a_of_type_Begr = ((begr)behe.a(this.jdField_a_of_type_AndroidAppActivity, null));
        View localView = a();
        this.jdField_a_of_type_Begr.setOnDismissListener(new axir(this));
        this.jdField_a_of_type_Begr.setOnKeyListener(new axis(this));
        this.jdField_a_of_type_Begr.a(localView, null);
      }
    } while (this.jdField_a_of_type_Begr.isShowing());
    this.jdField_a_of_type_Begr.show();
  }
  
  public void a(axit paramaxit)
  {
    this.jdField_a_of_type_Axit = paramaxit;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    this.d = paramString4;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected List<ncb>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ncb();
    ((ncb)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630983);
    ((ncb)localObject).jdField_a_of_type_Int = 2130838732;
    ((ncb)localObject).jdField_a_of_type_Boolean = true;
    ((ncb)localObject).jdField_b_of_type_Int = 2;
    ((ncb)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ncb();
    ((ncb)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131631003);
    ((ncb)localObject).jdField_a_of_type_Int = 2130838736;
    ((ncb)localObject).jdField_b_of_type_Int = 9;
    ((ncb)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ncb();
    ((ncb)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630986);
    ((ncb)localObject).jdField_a_of_type_Int = 2130838730;
    ((ncb)localObject).jdField_b_of_type_Int = 10;
    ((ncb)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ncb();
    ((ncb)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131631000);
    ((ncb)localObject).jdField_a_of_type_Int = 2130838735;
    ((ncb)localObject).jdField_a_of_type_Boolean = true;
    ((ncb)localObject).jdField_b_of_type_Int = 12;
    ((ncb)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    ncb localncb = new ncb();
    localncb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630991);
    localncb.jdField_a_of_type_Int = 2130837565;
    localncb.jdField_a_of_type_Boolean = true;
    localncb.jdField_b_of_type_Int = 26;
    localncb.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localncb);
    localncb = new ncb();
    localncb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630975);
    localncb.jdField_a_of_type_Int = 2130838728;
    localncb.jdField_a_of_type_Boolean = true;
    localncb.jdField_b_of_type_Int = 1;
    localncb.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localncb);
    localncb = new ncb();
    localncb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630981);
    localncb.jdField_a_of_type_Int = 2130842024;
    localncb.jdField_a_of_type_Boolean = true;
    localncb.jdField_b_of_type_Int = 11;
    localncb.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localncb);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing()))
    {
      this.jdField_a_of_type_Axit = null;
      this.jdField_a_of_type_Begr.dismiss();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ShareUtils", 2, "onItemClick, tag is null");
      }
    }
    do
    {
      return;
      paramAdapterView = ((ncd)paramAdapterView).a;
    } while (this.jdField_a_of_type_Axit == null);
    this.jdField_a_of_type_Axit.a(paramAdapterView.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axip
 * JD-Core Version:    0.7.0.1
 */