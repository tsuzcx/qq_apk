import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.view.QPhoneShare.2;
import java.util.ArrayList;
import java.util.List;

public class bfno
  implements AdapterView.OnItemClickListener
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 4;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private begr jdField_a_of_type_Begr;
  private ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public xdt a;
  private ElasticHorScrView b;
  
  public bfno(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    if ((this.jdField_a_of_type_Xdt == null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      this.jdField_a_of_type_Xdt = new xdt(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Xdt.a(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  @SuppressLint({"InflateParams"})
  @TargetApi(9)
  protected View a()
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131493481, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131309901));
    this.b = ((ElasticHorScrView)localView.findViewById(2131309902));
    GridView localGridView2 = (GridView)localView.findViewById(2131301556);
    GridView localGridView1 = (GridView)localView.findViewById(2131301557);
    Object localObject1 = (TextView)localView.findViewById(2131296391);
    ((TextView)localObject1).setText(2131625035);
    ((TextView)localObject1).setOnClickListener(new bfnp(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      this.b.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    Object localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label373;
      }
    }
    label373:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int i = ((List)localObject1).size();
      localGridView2.setNumColumns(i);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((i - 1) * 10 + i * 75 + 3) * this.jdField_a_of_type_Float));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new ncc(this.jdField_a_of_type_AndroidContentContext, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i = localLayoutParams.width;
      int j = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((j * 75 + (j - 1) * 10 + 3) * this.jdField_a_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(j);
      localGridView1.setAdapter(new ncc(this.jdField_a_of_type_AndroidContentContext, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new QPhoneShare.2(this, i, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public xdt a()
  {
    return this.jdField_a_of_type_Xdt;
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
        this.jdField_a_of_type_Begr.a(localView, null);
      }
    } while (this.jdField_a_of_type_Begr.isShowing());
    this.jdField_a_of_type_Begr.show();
  }
  
  protected List<ncb>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ncb localncb;
    if ((this.jdField_a_of_type_Int & 0x8) == 0)
    {
      localncb = new ncb();
      localncb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630983);
      localncb.jdField_a_of_type_Int = 2130838732;
      localncb.jdField_a_of_type_Boolean = true;
      localncb.jdField_b_of_type_Int = 2;
      localncb.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localncb);
    }
    if ((this.jdField_a_of_type_Int & 0x10) == 0)
    {
      localncb = new ncb();
      localncb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630996);
      localncb.jdField_a_of_type_Int = 2130838733;
      localncb.jdField_a_of_type_Boolean = true;
      localncb.jdField_b_of_type_Int = 3;
      localncb.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localncb);
    }
    if ((this.jdField_a_of_type_Int & 0x4000) == 0)
    {
      localncb = new ncb();
      localncb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131631003);
      localncb.jdField_a_of_type_Int = 2130838736;
      localncb.jdField_b_of_type_Int = 9;
      localncb.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localncb);
    }
    if ((this.jdField_a_of_type_Int & 0x8000) == 0)
    {
      localncb = new ncb();
      localncb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630986);
      localncb.jdField_a_of_type_Int = 2130838730;
      localncb.jdField_b_of_type_Int = 10;
      localncb.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localncb);
    }
    if ((this.jdField_a_of_type_Int & 0x1) == 0)
    {
      localncb = new ncb();
      localncb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630975);
      localncb.jdField_a_of_type_Int = 2130838728;
      localncb.jdField_a_of_type_Boolean = true;
      localncb.jdField_b_of_type_Int = 1;
      localncb.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localncb);
    }
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView != null)
      {
        bool = true;
        QLog.d("QPhoneShare", 2, bool);
      }
    }
    else
    {
      if (paramAdapterView != null) {
        break label59;
      }
    }
    label59:
    int i;
    label118:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if (this.jdField_a_of_type_Begr.isShowing()) {
          this.jdField_a_of_type_Begr.dismiss();
        }
        i = ((ncd)paramAdapterView).a.jdField_b_of_type_Int;
        if (i != 2) {
          break label118;
        }
      } while (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p));
      this.jdField_a_of_type_Xdt.a(null, 1, false);
      return;
      if (i != 3) {
        break label148;
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p));
    this.jdField_a_of_type_Xdt.a(null, 2, false);
    return;
    label148:
    if ((i == 9) || (i == 10)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131655008;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        vvp.a(0, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131655009;
        }
      }
      else
      {
        if (i == 9)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
            break;
          }
          this.jdField_a_of_type_Xdt.a(null, 3, true);
          return;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
          break;
        }
        this.jdField_a_of_type_Xdt.a(null, 4, true);
        return;
        if (i != 1) {
          break;
        }
        paramAdapterView = bfnm.a(this.jdField_a_of_type_Xdt.a());
        paramView = (ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard");
        if (paramView == null) {
          break;
        }
        paramView.setText(paramAdapterView);
        Toast.makeText(this.jdField_a_of_type_AndroidContentContext, "复制成功", 0).show();
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfno
 * JD-Core Version:    0.7.0.1
 */