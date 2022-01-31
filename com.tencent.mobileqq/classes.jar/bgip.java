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

public class bgip
  extends bcfh
{
  bgip(QQComicFragment paramQQComicFragment) {}
  
  private void a(amgn paramamgn, QQBrowserActivity paramQQBrowserActivity)
  {
    Object localObject2 = "";
    Object localObject3 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131690545);
    bgij localbgij = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    Object localObject1;
    if ((localbgij != null) && ((localbgij instanceof bgij)))
    {
      localObject1 = ((bgij)localbgij).c;
      localObject2 = ((bgij)localbgij).d;
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
            paramQQBrowserActivity = bgjl.a(bgjl.b((String)localObject3, "from", "1041001"), "from", "1041001");
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
              paramamgn.a(new bgiq(this, paramQQBrowserActivity, (String)localObject1, (String)localObject2, ((JSONObject)localObject3).toString().getBytes()));
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
    amgn localamgn = localQQBrowserActivity.a();
    if (localamgn != null)
    {
      if (localamgn.c()) {
        break label45;
      }
      if (localamgn.b())
      {
        localamgn.e();
        localQQBrowserActivity.finish();
      }
    }
    else
    {
      return;
    }
    localamgn.i();
    return;
    label45:
    localamgn.f();
  }
  
  public void a(bbjs parambbjs, bcvf parambcvf)
  {
    this.jdField_a_of_type_Bbjq.b();
    int j = parambbjs.c;
    parambbjs = a();
    parambcvf = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a(parambbjs);
    if (j == 2) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p))
      {
        this.jdField_a_of_type_Xmq.a(parambbjs, 1, false);
        VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 1, new String[] { parambcvf[0], parambcvf[1] });
      }
    }
    label411:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Xmq.a(parambbjs, 1, false);
        break;
        if (j == 3)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
            this.jdField_a_of_type_Xmq.a(parambbjs, 2, false);
          }
          for (;;)
          {
            VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 2, new String[] { parambcvf[0], parambcvf[1] });
            return;
            this.jdField_a_of_type_Xmq.a(parambbjs, 2, false);
          }
        }
        if ((j == 9) || (j == 10))
        {
          int i = -1;
          if (!WXShareHelper.a().a()) {
            i = 2131720917;
          }
          while (i != -1)
          {
            wij.a(0, i);
            return;
            if (!WXShareHelper.a().b()) {
              i = 2131720918;
            }
          }
          if (j == 9)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
              this.jdField_a_of_type_Xmq.a(parambbjs, 3, true);
            }
            for (;;)
            {
              VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 3, new String[] { parambcvf[0], parambcvf[1] });
              return;
              this.jdField_a_of_type_Xmq.a(parambbjs, 3, true);
            }
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
            this.jdField_a_of_type_Xmq.a(parambbjs, 4, true);
          }
          for (;;)
          {
            VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 4, new String[] { parambcvf[0], parambcvf[1] });
            return;
            this.jdField_a_of_type_Xmq.a(parambbjs, 4, true);
          }
        }
        if (j != 14) {
          break label411;
        }
      } while (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p));
      this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_Xmq.p, new String[] { "6" });
      return;
      if (j == 33)
      {
        this.jdField_a_of_type_CooperationComicUiQQComicFragment.g();
        return;
      }
    } while (j != 70);
    e();
  }
  
  public List<bbjs>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x8) == 0L)
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131696696);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130838754;
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).c = 2;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x10) == 0L)
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131696709);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130838755;
      ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject1).c = 3;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x4000) == 0L)
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131696716);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130838758;
      ((bbjs)localObject1).c = 9;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x8000) == 0L)
    {
      localObject1 = new bbjs();
      ((bbjs)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131696699);
      ((bbjs)localObject1).jdField_b_of_type_Int = 2130838752;
      ((bbjs)localObject1).c = 10;
      ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    Object localObject1 = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x2000) == 0L)
    {
      localObject2 = new bbjs();
      ((bbjs)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131689670);
      ((bbjs)localObject2).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject2).jdField_b_of_type_Int = 2130849656;
      ((bbjs)localObject2).c = 14;
      ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    Object localObject2 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    if ((localObject2 instanceof bgij))
    {
      localObject2 = (bgij)localObject2;
      if (((bgij)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0)
      {
        if (((bgij)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) {
          break label638;
        }
        i = 1;
        localObject3 = new bbjs();
        ((bbjs)localObject3).jdField_a_of_type_JavaLangString = ((bgij)localObject2).jdField_a_of_type_JavaLangString;
        ((bbjs)localObject3).jdField_b_of_type_Boolean = true;
        if (i == 0) {
          break label643;
        }
        i = 2130849666;
        label443:
        ((bbjs)localObject3).jdField_b_of_type_Int = i;
        ((bbjs)localObject3).c = 33;
        ((bbjs)localObject3).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    localObject2 = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
    Object localObject3 = ((QQBrowserActivity)localObject2).getOriginalUrl();
    if ((localObject3 != null) && (((String)localObject3).indexOf("cancelColorTab=1") == -1))
    {
      amgn localamgn = ((QQBrowserActivity)localObject2).a();
      a(localamgn, (QQBrowserActivity)localObject2);
      if ((localamgn != null) && (localamgn.a()) && (!amhh.c((String)localObject3)))
      {
        boolean bool = localamgn.c();
        localObject2 = new bbjs();
        localObject3 = BaseApplicationImpl.getApplication();
        if (bool) {
          break label650;
        }
        i = 2131690851;
        label568:
        ((bbjs)localObject2).jdField_a_of_type_JavaLangString = ((BaseApplicationImpl)localObject3).getString(i);
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
      ((bbjs)localObject2).jdField_b_of_type_Int = i;
      ((bbjs)localObject2).jdField_b_of_type_Boolean = true;
      ((bbjs)localObject2).c = 70;
      ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
      return (List[])new ArrayList[] { localArrayList, localObject1 };
      label638:
      i = 0;
      break;
      i = 2130849667;
      break label443;
      i = 2131690854;
      break label568;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgip
 * JD-Core Version:    0.7.0.1
 */