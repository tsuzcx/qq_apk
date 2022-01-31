import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.ui.QQComicFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class bfah
  extends bbbt
{
  bfah(QQComicFragment paramQQComicFragment) {}
  
  private void a(alrv paramalrv, QQBrowserActivity paramQQBrowserActivity)
  {
    Object localObject2 = "";
    Object localObject3 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131624984);
    bfab localbfab = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    Object localObject1;
    if ((localbfab != null) && ((localbfab instanceof bfab)))
    {
      localObject1 = ((bfab)localbfab).c;
      localObject2 = ((bfab)localbfab).d;
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
            paramQQBrowserActivity = bfbd.a(bfbd.b((String)localObject3, "from", "1041001"), "from", "1041001");
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
              paramalrv.a(new bfai(this, paramQQBrowserActivity, (String)localObject1, (String)localObject2, ((JSONObject)localObject3).toString().getBytes()));
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
    alrv localalrv = localQQBrowserActivity.a();
    if (localalrv != null)
    {
      if (localalrv.c()) {
        break label45;
      }
      if (localalrv.b())
      {
        localalrv.e();
        localQQBrowserActivity.finish();
      }
    }
    else
    {
      return;
    }
    localalrv.i();
    return;
    label45:
    localalrv.f();
  }
  
  public List<bahx>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x8) == 0L)
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131630983);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130838732;
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).c = 2;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x10) == 0L)
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131630996);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130838733;
      ((bahx)localObject1).jdField_b_of_type_Boolean = true;
      ((bahx)localObject1).c = 3;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x4000) == 0L)
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131631003);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130838736;
      ((bahx)localObject1).c = 9;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x8000) == 0L)
    {
      localObject1 = new bahx();
      ((bahx)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131630986);
      ((bahx)localObject1).jdField_b_of_type_Int = 2130838730;
      ((bahx)localObject1).c = 10;
      ((bahx)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    Object localObject1 = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x2000) == 0L)
    {
      localObject2 = new bahx();
      ((bahx)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131624130);
      ((bahx)localObject2).jdField_b_of_type_Boolean = true;
      ((bahx)localObject2).jdField_b_of_type_Int = 2130849411;
      ((bahx)localObject2).c = 14;
      ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    Object localObject2 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    if ((localObject2 instanceof bfab))
    {
      localObject2 = (bfab)localObject2;
      if (((bfab)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0)
      {
        if (((bfab)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) {
          break label622;
        }
        i = 1;
        localObject3 = new bahx();
        ((bahx)localObject3).jdField_a_of_type_JavaLangString = ((bfab)localObject2).jdField_a_of_type_JavaLangString;
        ((bahx)localObject3).jdField_b_of_type_Boolean = true;
        if (i == 0) {
          break label627;
        }
        i = 2130849421;
        label435:
        ((bahx)localObject3).jdField_b_of_type_Int = i;
        ((bahx)localObject3).c = 33;
        ((bahx)localObject3).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    localObject2 = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
    Object localObject3 = ((QQBrowserActivity)localObject2).getOriginalUrl();
    if (((String)localObject3).indexOf("cancelColorTab=1") == -1)
    {
      alrv localalrv = ((QQBrowserActivity)localObject2).a();
      a(localalrv, (QQBrowserActivity)localObject2);
      if ((localalrv != null) && (localalrv.a()) && (!alsr.c((String)localObject3)))
      {
        boolean bool = localalrv.c();
        localObject2 = new bahx();
        localObject3 = BaseApplicationImpl.getApplication();
        if (bool) {
          break label633;
        }
        i = 2131625288;
        label553:
        ((bahx)localObject2).jdField_a_of_type_JavaLangString = ((BaseApplicationImpl)localObject3).getString(i);
        if (bool) {
          break label639;
        }
      }
    }
    label622:
    label627:
    label633:
    label639:
    for (int i = 2130841707;; i = 2130841709)
    {
      ((bahx)localObject2).jdField_b_of_type_Int = i;
      ((bahx)localObject2).jdField_b_of_type_Boolean = true;
      ((bahx)localObject2).c = 70;
      ((bahx)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
      return (List[])new ArrayList[] { localArrayList, localObject1 };
      i = 0;
      break;
      i = 2130849422;
      break label435;
      i = 2131625291;
      break label553;
    }
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
        QLog.d("WebLog_WebViewFragment", 2, bool);
      }
    }
    else
    {
      if (paramAdapterView != null) {
        break label57;
      }
    }
    label57:
    int i;
    label489:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        this.jdField_a_of_type_Bahv.b();
        i = ((baia)paramAdapterView).a.c;
        paramAdapterView = a();
        paramView = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a(paramAdapterView);
        if (i == 2)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
            this.jdField_a_of_type_Xdt.a(paramAdapterView, 1, false);
          }
          for (;;)
          {
            bajr.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 1, new String[] { paramView[0], paramView[1] });
            return;
            this.jdField_a_of_type_Xdt.a(paramAdapterView, 1, false);
          }
        }
        if (i == 3)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
            this.jdField_a_of_type_Xdt.a(paramAdapterView, 2, false);
          }
          for (;;)
          {
            bajr.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 2, new String[] { paramView[0], paramView[1] });
            return;
            this.jdField_a_of_type_Xdt.a(paramAdapterView, 2, false);
          }
        }
        if ((i == 9) || (i == 10))
        {
          paramInt = -1;
          if (!WXShareHelper.a().a()) {
            paramInt = 2131655008;
          }
          while (paramInt != -1)
          {
            vvp.a(0, paramInt);
            return;
            if (!WXShareHelper.a().b()) {
              paramInt = 2131655009;
            }
          }
          if (i == 9)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
              this.jdField_a_of_type_Xdt.a(paramAdapterView, 3, true);
            }
            for (;;)
            {
              bajr.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 3, new String[] { paramView[0], paramView[1] });
              return;
              this.jdField_a_of_type_Xdt.a(paramAdapterView, 3, true);
            }
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p)) {
            this.jdField_a_of_type_Xdt.a(paramAdapterView, 4, true);
          }
          for (;;)
          {
            bajr.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 4, new String[] { paramView[0], paramView[1] });
            return;
            this.jdField_a_of_type_Xdt.a(paramAdapterView, 4, true);
          }
        }
        if (i != 14) {
          break label489;
        }
      } while (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.p));
      this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_Xdt.p, new String[] { "6" });
      return;
      if (i == 33)
      {
        this.jdField_a_of_type_CooperationComicUiQQComicFragment.g();
        return;
      }
    } while (i != 70);
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfah
 * JD-Core Version:    0.7.0.1
 */