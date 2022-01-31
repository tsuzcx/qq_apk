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

public class bijn
  extends beei
{
  bijn(QQComicFragment paramQQComicFragment) {}
  
  private void a(anxn paramanxn, QQBrowserActivity paramQQBrowserActivity)
  {
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject3 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131690596);
    bijh localbijh = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    if (localbijh != null)
    {
      localObject1 = localbijh.c;
      localObject2 = localbijh.d;
    }
    if ((((String)localObject1).isEmpty()) && (this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_Bebk != null)) {
      if (!this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_Bebk.a().isEmpty()) {
        localObject1 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_Bebk.a();
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
          paramQQBrowserActivity = bikj.a(bikj.b((String)localObject3, "from", "1041001"), "from", "1041001");
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
            paramanxn.a(new bijo(this, paramQQBrowserActivity, (String)localObject1, (String)localObject2, ((JSONObject)localObject3).toString().getBytes()));
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
    anxn localanxn = localQQBrowserActivity.a();
    if (localanxn != null)
    {
      if (localanxn.c()) {
        break label45;
      }
      if (localanxn.b())
      {
        localanxn.e();
        localQQBrowserActivity.finish();
      }
    }
    else
    {
      return;
    }
    localanxn.i();
    return;
    label45:
    localanxn.f();
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    String[] arrayOfString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300392", arrayOfString[1], new String[] { arrayOfString[2], "6" });
    if ((this.jdField_a_of_type_Long & 0x8) == 0L)
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
      biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300392", arrayOfString[1], new String[] { arrayOfString[2], "1" });
    }
    if ((this.jdField_a_of_type_Long & 0x10) == 0L)
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
      biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300392", arrayOfString[1], new String[] { arrayOfString[2], "2" });
    }
    boolean bool = WXShareHelper.a().a();
    if (((this.jdField_a_of_type_Long & 0x4000) == 0L) && (bool))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300392", arrayOfString[1], new String[] { arrayOfString[2], "3" });
    }
    if (((this.jdField_a_of_type_Long & 0x8000) == 0L) && (bool))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
      biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300392", arrayOfString[1], new String[] { arrayOfString[2], "4" });
    }
    ArrayList localArrayList2 = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x2000) == 0L)
    {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
      biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300393", arrayOfString[1], new String[] { arrayOfString[2], "1" });
    }
    Object localObject = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    int j;
    if ((localObject != null) && (((bijh)localObject).a.get() >= 0))
    {
      if (((bijh)localObject).a.get() == 1)
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
        biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300393", arrayOfString[1], new String[] { arrayOfString[2], localObject });
      }
    }
    else
    {
      localObject = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
      String str = ((QQBrowserActivity)localObject).getOriginalUrl();
      if ((str != null) && (str.indexOf("cancelColorTab=1") == -1))
      {
        anxn localanxn = ((QQBrowserActivity)localObject).a();
        a(localanxn, (QQBrowserActivity)localObject);
        if ((localanxn != null) && (localanxn.a()) && (!anyi.c(str)))
        {
          if (!localanxn.c()) {
            break label657;
          }
          localObject = "3";
        }
      }
    }
    for (int i = 82;; i = 70)
    {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(i));
      biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "3", "300393", arrayOfString[1], new String[] { arrayOfString[2], localObject });
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
      if (TextUtils.isEmpty(this.jdField_a_of_type_Zbj.p))
      {
        this.jdField_a_of_type_Zbj.a(paramShareActionSheet, 1, false);
        return;
      }
      this.jdField_a_of_type_Zbj.a(paramShareActionSheet, 1, false);
      return;
    }
    if (j == 3)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_Zbj.p))
      {
        this.jdField_a_of_type_Zbj.a(paramShareActionSheet, 2, false);
        return;
      }
      this.jdField_a_of_type_Zbj.a(paramShareActionSheet, 2, false);
      return;
    }
    int i;
    if ((j == 9) || (j == 10)) {
      if (!WXShareHelper.a().a()) {
        i = 2131721478;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        xxb.a(0, i);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131721479;
        }
      }
      else
      {
        if (j == 9)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Zbj.p))
          {
            this.jdField_a_of_type_Zbj.a(paramShareActionSheet, 3, true);
            return;
          }
          this.jdField_a_of_type_Zbj.a(paramShareActionSheet, 3, true);
          return;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_Zbj.p))
        {
          this.jdField_a_of_type_Zbj.a(paramShareActionSheet, 4, true);
          return;
        }
        this.jdField_a_of_type_Zbj.a(paramShareActionSheet, 4, true);
        return;
        if (j == 14)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Zbj.p)) {
            break;
          }
          this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_Zbj.p, new String[] { "6" });
          biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "2", "210393", arrayOfString[1], new String[] { arrayOfString[2], "1" });
          return;
        }
        if (j == 117)
        {
          biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "2", "210393", arrayOfString[1], new String[] { arrayOfString[2], "5" });
          this.jdField_a_of_type_CooperationComicUiQQComicFragment.g();
          return;
        }
        if (j == 116)
        {
          biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "2", "210393", arrayOfString[1], new String[] { arrayOfString[2], "4" });
          this.jdField_a_of_type_CooperationComicUiQQComicFragment.g();
          return;
        }
        if (j == 70)
        {
          biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "2", "210393", arrayOfString[1], new String[] { arrayOfString[2], "2" });
          e();
          return;
        }
        if (j == 82)
        {
          biiv.a(this.jdField_a_of_type_CooperationComicUiQQComicFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, arrayOfString[0], "2", "210393", arrayOfString[1], new String[] { arrayOfString[2], "3" });
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
        if (TextUtils.isEmpty(this.jdField_a_of_type_Zbj.p))
        {
          this.jdField_a_of_type_Zbj.a(paramShareActionSheet, 1, false);
          return;
        }
        if (this.jdField_a_of_type_Zbj.a == null) {
          break;
        }
        this.jdField_a_of_type_Zbj.a().show();
        this.jdField_a_of_type_Zbj.a.callJs(this.jdField_a_of_type_Zbj.p, new String[] { String.valueOf(101) });
        return;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bijn
 * JD-Core Version:    0.7.0.1
 */