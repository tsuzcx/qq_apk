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

public class bgwm
  implements AdapterView.OnItemClickListener
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 4;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private bfpc jdField_a_of_type_Bfpc;
  private ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public xmq a;
  private ElasticHorScrView b;
  
  public bgwm(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    if ((this.jdField_a_of_type_Xmq == null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      this.jdField_a_of_type_Xmq = new xmq(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Xmq.a(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  @SuppressLint({"InflateParams"})
  @TargetApi(9)
  protected View a()
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131559044, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375664));
    this.b = ((ElasticHorScrView)localView.findViewById(2131375665));
    GridView localGridView2 = (GridView)localView.findViewById(2131367168);
    GridView localGridView1 = (GridView)localView.findViewById(2131367169);
    Object localObject1 = (TextView)localView.findViewById(2131361926);
    ((TextView)localObject1).setText(2131690596);
    ((TextView)localObject1).setOnClickListener(new bgwn(this));
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
      localGridView2.setAdapter(new nna(this.jdField_a_of_type_AndroidContentContext, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i = localLayoutParams.width;
      int j = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((j * 75 + (j - 1) * 10 + 3) * this.jdField_a_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(j);
      localGridView1.setAdapter(new nna(this.jdField_a_of_type_AndroidContentContext, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new QPhoneShare.2(this, i, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public xmq a()
  {
    return this.jdField_a_of_type_Xmq;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bfpc == null)
      {
        this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(this.jdField_a_of_type_AndroidAppActivity, null));
        View localView = a();
        this.jdField_a_of_type_Bfpc.a(localView, null);
      }
    } while (this.jdField_a_of_type_Bfpc.isShowing());
    this.jdField_a_of_type_Bfpc.show();
  }
  
  protected List<nmz>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    nmz localnmz;
    if ((this.jdField_a_of_type_Int & 0x8) == 0)
    {
      localnmz = new nmz();
      localnmz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696696);
      localnmz.jdField_a_of_type_Int = 2130838754;
      localnmz.jdField_a_of_type_Boolean = true;
      localnmz.jdField_b_of_type_Int = 2;
      localnmz.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localnmz);
    }
    if ((this.jdField_a_of_type_Int & 0x10) == 0)
    {
      localnmz = new nmz();
      localnmz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696709);
      localnmz.jdField_a_of_type_Int = 2130838755;
      localnmz.jdField_a_of_type_Boolean = true;
      localnmz.jdField_b_of_type_Int = 3;
      localnmz.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localnmz);
    }
    if ((this.jdField_a_of_type_Int & 0x4000) == 0)
    {
      localnmz = new nmz();
      localnmz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696716);
      localnmz.jdField_a_of_type_Int = 2130838758;
      localnmz.jdField_b_of_type_Int = 9;
      localnmz.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localnmz);
    }
    if ((this.jdField_a_of_type_Int & 0x8000) == 0)
    {
      localnmz = new nmz();
      localnmz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696699);
      localnmz.jdField_a_of_type_Int = 2130838752;
      localnmz.jdField_b_of_type_Int = 10;
      localnmz.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localnmz);
    }
    if ((this.jdField_a_of_type_Int & 0x1) == 0)
    {
      localnmz = new nmz();
      localnmz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696688);
      localnmz.jdField_a_of_type_Int = 2130838750;
      localnmz.jdField_a_of_type_Boolean = true;
      localnmz.jdField_b_of_type_Int = 1;
      localnmz.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localnmz);
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
        if (this.jdField_a_of_type_Bfpc.isShowing()) {
          this.jdField_a_of_type_Bfpc.dismiss();
        }
        i = ((nnb)paramAdapterView).a.jdField_b_of_type_Int;
        if (i != 2) {
          break label118;
        }
      } while (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p));
      this.jdField_a_of_type_Xmq.a(null, 1, false);
      return;
      if (i != 3) {
        break label148;
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p));
    this.jdField_a_of_type_Xmq.a(null, 2, false);
    return;
    label148:
    if ((i == 9) || (i == 10)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720917;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        wij.a(0, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131720918;
        }
      }
      else
      {
        if (i == 9)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
            break;
          }
          this.jdField_a_of_type_Xmq.a(null, 3, true);
          return;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
          break;
        }
        this.jdField_a_of_type_Xmq.a(null, 4, true);
        return;
        if (i != 1) {
          break;
        }
        paramAdapterView = bgwk.a(this.jdField_a_of_type_Xmq.a());
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
 * Qualified Name:     bgwm
 * JD-Core Version:    0.7.0.1
 */