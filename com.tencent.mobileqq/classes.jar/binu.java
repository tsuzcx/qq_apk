import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.ui.QQComicFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class binu
  extends beir
{
  binu(QQComicFragment paramQQComicFragment) {}
  
  private void a(aobw paramaobw, QQBrowserActivity paramQQBrowserActivity)
  {
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject3 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131690596);
    bino localbino = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    if (localbino != null)
    {
      localObject1 = localbino.c;
      localObject2 = localbino.d;
    }
    if ((((String)localObject1).isEmpty()) && (this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_Beft != null)) {
      if (!this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_Beft.a().isEmpty()) {
        localObject1 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_Beft.a();
      }
    }
    for (;;)
    {
      if (((String)localObject2).isEmpty()) {
        if (((String)localObject1).equals(localObject3)) {
          localObject2 = paramQQBrowserActivity.getOriginalUrl();
        }
      }
      for (;;)
      {
        for (;;)
        {
          localObject3 = paramQQBrowserActivity.getOriginalUrl();
          paramQQBrowserActivity = bioq.a(bioq.b((String)localObject3, "from", "1041001"), "from", "1041001");
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
            paramaobw.a(new binv(this, paramQQBrowserActivity, (String)localObject1, (String)localObject2, ((JSONObject)localObject3).toString().getBytes()));
            return;
            localObject1 = localObject3;
            break;
            localObject2 = localObject3;
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
  }
  
  private void e()
  {
    QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
    aobw localaobw = localQQBrowserActivity.a();
    if (localaobw != null)
    {
      if (localaobw.c()) {
        break label45;
      }
      if (localaobw.b())
      {
        localaobw.e();
        localQQBrowserActivity.finish();
      }
    }
    else
    {
      return;
    }
    localaobw.i();
    return;
    label45:
    localaobw.f();
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    String[] arrayOfString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300392", arrayOfString[1], new String[] { arrayOfString[2], "6" });
    if ((this.jdField_a_of_type_Long & 0x8) == 0L)
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
      binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300392", arrayOfString[1], new String[] { arrayOfString[2], "1" });
    }
    if ((this.jdField_a_of_type_Long & 0x10) == 0L)
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
      binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300392", arrayOfString[1], new String[] { arrayOfString[2], "2" });
    }
    boolean bool = WXShareHelper.a().a();
    if (((this.jdField_a_of_type_Long & 0x4000) == 0L) && (bool))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300392", arrayOfString[1], new String[] { arrayOfString[2], "3" });
    }
    if (((this.jdField_a_of_type_Long & 0x8000) == 0L) && (bool))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
      binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300392", arrayOfString[1], new String[] { arrayOfString[2], "4" });
    }
    ArrayList localArrayList2 = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x2000) == 0L)
    {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
      binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300393", arrayOfString[1], new String[] { arrayOfString[2], "1" });
    }
    Object localObject = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    int j;
    if ((localObject != null) && (((bino)localObject).a.get() >= 0))
    {
      if (((bino)localObject).a.get() == 1)
      {
        i = 1;
        if (i == 0) {
          break label644;
        }
        j = 117;
        label434:
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(j));
        if (i == 0) {
          break label650;
        }
        localObject = "5";
        label452:
        binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300393", arrayOfString[1], new String[] { arrayOfString[2], localObject });
      }
    }
    else
    {
      localObject = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
      String str = ((QQBrowserActivity)localObject).getOriginalUrl();
      if ((str != null) && (str.indexOf("cancelColorTab=1") == -1))
      {
        aobw localaobw = ((QQBrowserActivity)localObject).a();
        a(localaobw, (QQBrowserActivity)localObject);
        if ((localaobw != null) && (localaobw.a()) && (!aocr.c(str)))
        {
          if (!localaobw.c()) {
            break label657;
          }
          localObject = "3";
        }
      }
    }
    for (int i = 82;; i = 70)
    {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(i));
      binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300393", arrayOfString[1], new String[] { arrayOfString[2], localObject });
      return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
      i = 0;
      break;
      label644:
      j = 116;
      break label434;
      label650:
      localObject = "4";
      break label452;
      label657:
      localObject = "2";
    }
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    int j = paramActionSheetItem.action;
    paramShareActionSheet = a();
    String[] arrayOfString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    if ((j == 2) || (j == 73))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_Zfy.p))
      {
        this.jdField_a_of_type_Zfy.a(paramShareActionSheet, 1, false);
        return;
      }
      this.jdField_a_of_type_Zfy.a(paramShareActionSheet, 1, false);
      return;
    }
    if (j == 3)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_Zfy.p))
      {
        this.jdField_a_of_type_Zfy.a(paramShareActionSheet, 2, false);
        return;
      }
      this.jdField_a_of_type_Zfy.a(paramShareActionSheet, 2, false);
      return;
    }
    int i;
    if ((j == 9) || (j == 10)) {
      if (!WXShareHelper.a().a()) {
        i = 2131721491;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        ybk.a(0, i);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131721492;
        }
      }
      else
      {
        if (j == 9)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Zfy.p))
          {
            this.jdField_a_of_type_Zfy.a(paramShareActionSheet, 3, true);
            return;
          }
          this.jdField_a_of_type_Zfy.a(paramShareActionSheet, 3, true);
          return;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_Zfy.p))
        {
          this.jdField_a_of_type_Zfy.a(paramShareActionSheet, 4, true);
          return;
        }
        this.jdField_a_of_type_Zfy.a(paramShareActionSheet, 4, true);
        return;
        if (j == 14)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Zfy.p)) {
            break;
          }
          this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_Zfy.p, new String[] { "6" });
          binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "2", "210393", arrayOfString[1], new String[] { arrayOfString[2], "1" });
          return;
        }
        if (j == 117)
        {
          binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "2", "210393", arrayOfString[1], new String[] { arrayOfString[2], "5" });
          this.jdField_a_of_type_CooperationComicUiQQComicFragment.g();
          return;
        }
        if (j == 116)
        {
          binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "2", "210393", arrayOfString[1], new String[] { arrayOfString[2], "4" });
          this.jdField_a_of_type_CooperationComicUiQQComicFragment.g();
          return;
        }
        if (j == 70)
        {
          binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "2", "210393", arrayOfString[1], new String[] { arrayOfString[2], "2" });
          e();
          return;
        }
        if (j == 82)
        {
          binc.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "2", "210393", arrayOfString[1], new String[] { arrayOfString[2], "3" });
          e();
          return;
        }
        if (j != 72) {
          break;
        }
        if (this.jdField_a_of_type_AndroidOsBundle == null) {
          this.jdField_a_of_type_AndroidOsBundle = new Bundle();
        }
        this.jdField_a_of_type_AndroidOsBundle.putString("to_qq", paramActionSheetItem.uin);
        this.jdField_a_of_type_AndroidOsBundle.putString("to_uin_name", paramActionSheetItem.label);
        this.jdField_a_of_type_AndroidOsBundle.putInt("to_uin_type", paramActionSheetItem.uinType);
        if (TextUtils.isEmpty(this.jdField_a_of_type_Zfy.p))
        {
          this.jdField_a_of_type_Zfy.a(paramShareActionSheet, 1, false);
          return;
        }
        if (this.jdField_a_of_type_Zfy.a == null) {
          break;
        }
        this.jdField_a_of_type_Zfy.a().show();
        this.jdField_a_of_type_Zfy.a.callJs(this.jdField_a_of_type_Zfy.p, new String[] { String.valueOf(101) });
        return;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     binu
 * JD-Core Version:    0.7.0.1
 */