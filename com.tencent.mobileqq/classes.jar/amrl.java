import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.jsp.QQComicJsPlugin;
import cooperation.comic.ui.QQComicFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class amrl
  extends SwiftBrowserShareMenuHandler
{
  amrl(QQComicFragment paramQQComicFragment) {}
  
  public List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x8) == 0L)
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131430110);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130838341;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).c = 2;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x10) == 0L)
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131430116);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130838342;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).c = 3;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x4000) == 0L)
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131430128);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130838345;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).c = 9;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    if ((this.jdField_a_of_type_Long & 0x8000) == 0L)
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131430129);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130838339;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).c = 10;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
    }
    Object localObject1 = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x2000) == 0L)
    {
      localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131435278);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130846422;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).c = 14;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    Object localObject2 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((localObject2 instanceof QQComicJsPlugin))
    {
      localObject2 = (QQComicJsPlugin)localObject2;
      if (((QQComicJsPlugin)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0)
      {
        if (((QQComicJsPlugin)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) {
          break label450;
        }
        i = 1;
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.jdField_a_of_type_JavaLangString = ((QQComicJsPlugin)localObject2).jdField_a_of_type_JavaLangString;
        localActionSheetItem.jdField_a_of_type_Boolean = true;
        if (i == 0) {
          break label455;
        }
      }
    }
    label450:
    label455:
    for (int i = 2130846430;; i = 2130846431)
    {
      localActionSheetItem.jdField_b_of_type_Int = i;
      localActionSheetItem.c = 33;
      localActionSheetItem.jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localActionSheetItem);
      return (List[])new ArrayList[] { localArrayList, localObject1 };
      i = 0;
      break;
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
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
    label474:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
        i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.c;
        paramAdapterView = a();
        paramView = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a(paramAdapterView);
        if (i == 2)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.n)) {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 1, false);
          }
          for (;;)
          {
            VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 1, new String[] { paramView[0], paramView[1] });
            return;
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 1, false);
          }
        }
        if (i == 3)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.n)) {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 2, false);
          }
          for (;;)
          {
            VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 2, new String[] { paramView[0], paramView[1] });
            return;
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 2, false);
          }
        }
        if ((i == 9) || (i == 10))
        {
          paramInt = -1;
          if (!WXShareHelper.a().a()) {
            paramInt = 2131435335;
          }
          while (paramInt != -1)
          {
            QRUtils.a(0, paramInt);
            return;
            if (!WXShareHelper.a().b()) {
              paramInt = 2131435336;
            }
          }
          if (i == 9)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.n)) {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, true);
            }
            for (;;)
            {
              VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 3, new String[] { paramView[0], paramView[1] });
              return;
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, true);
            }
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.n)) {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, true);
          }
          for (;;)
          {
            VipUtils.a(null, "VIPCOMIC", "0X800555E", "0X800555E", 0, 4, new String[] { paramView[0], paramView[1] });
            return;
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, true);
          }
        }
        if (i != 14) {
          break label474;
        }
      } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.n));
      this.jdField_a_of_type_CooperationComicUiQQComicFragment.a().a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.n, new String[] { "6" });
      return;
    } while (i != 33);
    this.jdField_a_of_type_CooperationComicUiQQComicFragment.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrl
 * JD-Core Version:    0.7.0.1
 */