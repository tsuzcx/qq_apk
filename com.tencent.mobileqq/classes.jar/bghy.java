import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.ui.QQComicFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class bghy
  extends bcet
{
  bghy(QQComicFragment paramQQComicFragment) {}
  
  private void a(amgo paramamgo, QQBrowserActivity paramQQBrowserActivity)
  {
    Object localObject2 = "";
    Object localObject3 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131690545);
    bghs localbghs = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    Object localObject1;
    if ((localbghs != null) && ((localbghs instanceof bghs)))
    {
      localObject1 = ((bghs)localbghs).c;
      localObject2 = ((bghs)localbghs).d;
    }
    for (;;)
    {
      if ((((String)localObject1).isEmpty()) && (this.jdField_a_of_type_CooperationComicUiQQComicFragment.a != null)) {
        if (!this.jdField_a_of_type_CooperationComicUiQQComicFragment.a.a().isEmpty()) {
          localObject1 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a.a();
        }
      }
      for (;;)
      {
        if (((String)localObject2).isEmpty())
        {
          localObject2 = localObject3;
          if (((String)localObject1).equals(localObject3)) {
            localObject2 = paramQQBrowserActivity.getOriginalUrl();
          }
        }
        for (;;)
        {
          for (;;)
          {
            localObject3 = paramQQBrowserActivity.getOriginalUrl();
            paramQQBrowserActivity = bgiu.a(bgiu.b((String)localObject3, "from", "1041001"), "from", "1041001");
            if (QLog.isColorLevel()) {
              QLog.d("WebLog_WebViewFragment", 2, "originalUrl is " + (String)localObject3 + " ,newUrl is " + paramQQBrowserActivity);
            }
            localObject3 = new JSONObject();
            try
            {
              ((JSONObject)localObject3).put("colorNoteType", 2);
              if (QLog.isColorLevel()) {
                QLog.d("WebLog_WebViewFragment", 2, "ColorNote mainTitle is " + (String)localObject1 + ",subTitle is " + (String)localObject2 + ",subType is " + paramQQBrowserActivity);
              }
              paramamgo.a(new bghz(this, paramQQBrowserActivity, (String)localObject1, (String)localObject2, ((JSONObject)localObject3).toString().getBytes()));
              return;
              localObject1 = localObject3;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
      }
      localObject1 = "";
    }
  }
  
  private void e()
  {
    QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
    amgo localamgo = localQQBrowserActivity.a();
    if (localamgo != null)
    {
      if (localamgo.c()) {
        break label45;
      }
      if (localamgo.b())
      {
        localamgo.e();
        localQQBrowserActivity.finish();
      }
    }
    else
    {
      return;
    }
    localamgo.i();
    return;
    label45:
    localamgo.f();
  }
  
  public void a(bbje parambbje, bcuq parambcuq)
  {
    this.jdField_a_of_type_Bbjc.b();
    int j = parambbje.c;
    parambbje = a();
    parambcuq = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a(parambbje);
    if (j == 2) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_Xmt.p))
      {
        this.jdField_a_of_type_Xmt.a(parambbje, 1, false);
        VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 1, new String[] { parambcuq[0], parambcuq[1] });
      }
    }
    label411:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Xmt.a(parambbje, 1, false);
        break;
        if (j == 3)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Xmt.p)) {
            this.jdField_a_of_type_Xmt.a(parambbje, 2, false);
          }
          for (;;)
          {
            VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 2, new String[] { parambcuq[0], parambcuq[1] });
            return;
            this.jdField_a_of_type_Xmt.a(parambbje, 2, false);
          }
        }
        if ((j == 9) || (j == 10))
        {
          int i = -1;
          if (!WXShareHelper.a().a()) {
            i = 2131720906;
          }
          while (i != -1)
          {
            wim.a(0, i);
            return;
            if (!WXShareHelper.a().b()) {
              i = 2131720907;
            }
          }
          if (j == 9)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_Xmt.p)) {
              this.jdField_a_of_type_Xmt.a(parambbje, 3, true);
            }
            for (;;)
            {
              VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 3, new String[] { parambcuq[0], parambcuq[1] });
              return;
              this.jdField_a_of_type_Xmt.a(parambbje, 3, true);
            }
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_Xmt.p)) {
            this.jdField_a_of_type_Xmt.a(parambbje, 4, true);
          }
          for (;;)
          {
            VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 4, new String[] { parambcuq[0], parambcuq[1] });
            return;
            this.jdField_a_of_type_Xmt.a(parambbje, 4, true);
          }
        }
        if (j != 14) {
          break label411;
        }
      } while (TextUtils.isEmpty(this.jdField_a_of_type_Xmt.p));
      this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_Xmt.p, new String[] { "6" });
      return;
      if (j == 33)
      {
        this.jdField_a_of_type_CooperationComicUiQQComicFragment.g();
        return;
      }
    } while (j != 70);
    e();
  }
  
  public List<bbje>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x8) == 0L)
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131696695);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130838754;
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).c = 2;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x10) == 0L)
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131696708);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130838755;
      ((bbje)localObject1).jdField_b_of_type_Boolean = true;
      ((bbje)localObject1).c = 3;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x4000) == 0L)
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131696715);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130838758;
      ((bbje)localObject1).c = 9;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x8000) == 0L)
    {
      localObject1 = new bbje();
      ((bbje)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131696698);
      ((bbje)localObject1).jdField_b_of_type_Int = 2130838752;
      ((bbje)localObject1).c = 10;
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    Object localObject1 = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x2000) == 0L)
    {
      localObject2 = new bbje();
      ((bbje)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131689670);
      ((bbje)localObject2).jdField_b_of_type_Boolean = true;
      ((bbje)localObject2).jdField_b_of_type_Int = 2130849647;
      ((bbje)localObject2).c = 14;
      ((bbje)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    Object localObject2 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    if ((localObject2 instanceof bghs))
    {
      localObject2 = (bghs)localObject2;
      if (((bghs)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0)
      {
        if (((bghs)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) {
          break label638;
        }
        i = 1;
        localObject3 = new bbje();
        ((bbje)localObject3).jdField_a_of_type_JavaLangString = ((bghs)localObject2).jdField_a_of_type_JavaLangString;
        ((bbje)localObject3).jdField_b_of_type_Boolean = true;
        if (i == 0) {
          break label643;
        }
        i = 2130849657;
        label443:
        ((bbje)localObject3).jdField_b_of_type_Int = i;
        ((bbje)localObject3).c = 33;
        ((bbje)localObject3).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    localObject2 = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
    Object localObject3 = ((QQBrowserActivity)localObject2).getOriginalUrl();
    if ((localObject3 != null) && (((String)localObject3).indexOf("cancelColorTab=1") == -1))
    {
      amgo localamgo = ((QQBrowserActivity)localObject2).a();
      a(localamgo, (QQBrowserActivity)localObject2);
      if ((localamgo != null) && (localamgo.a()) && (!amhi.c((String)localObject3)))
      {
        boolean bool = localamgo.c();
        localObject2 = new bbje();
        localObject3 = BaseApplicationImpl.getApplication();
        if (bool) {
          break label650;
        }
        i = 2131690851;
        label568:
        ((bbje)localObject2).jdField_a_of_type_JavaLangString = ((BaseApplicationImpl)localObject3).getString(i);
        if (bool) {
          break label657;
        }
      }
    }
    label643:
    label650:
    label657:
    for (int i = 2130841802;; i = 2130841803)
    {
      ((bbje)localObject2).jdField_b_of_type_Int = i;
      ((bbje)localObject2).jdField_b_of_type_Boolean = true;
      ((bbje)localObject2).c = 70;
      ((bbje)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
      return (List[])new ArrayList[] { localArrayList, localObject1 };
      label638:
      i = 0;
      break;
      i = 2130849658;
      break label443;
      i = 2131690854;
      break label568;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghy
 * JD-Core Version:    0.7.0.1
 */