import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.ThemeImageView;
import cooperation.ilive.share.IliveShareHelper;

public class bkjo
  implements ahqq, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkjt jdField_a_of_type_Bkjt;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private PatchedButton jdField_a_of_type_ComTencentWidgetPatchedButton;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  
  public bkjo(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837987);
    c();
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378900));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378903));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131378901));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378902));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bjuk.c);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_a_of_type_Int = AIOUtils.dp2px(39.0F, this.jdField_a_of_type_AndroidViewView.getResources());
  }
  
  @TargetApi(19)
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("IliveGroupTipsBar", 2, "initBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals((String)this.jdField_a_of_type_ComTencentWidgetThemeImageView.getTag())))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      int i = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bfol.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, 6));
      ((URLDrawable)localObject).setDecodeHandler(bfol.e);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setTag(paramString);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.setDecodeHandler(null);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372214));
    b();
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBar", 2, "showBlurView() called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372135);
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) || (ThemeUtil.isSimpleDayTheme(false)))
    {
      localView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBar", 2, "showBlurView() visibility called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      }
      return;
    }
    localView.setBackgroundColor(this.jdField_a_of_type_AndroidViewView.getResources().getColor(2131166984));
    localView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBar", 2, "showBlurView() gone called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
  }
  
  private void c(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(paramString);
  }
  
  private void d(String paramString)
  {
    this.b.setText(paramString);
    this.b.setContentDescription(paramString);
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131560922, null);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    QLog.i("IliveGroupTipsBar", 1, "bars onAIOEvent eventType = " + paramInt);
  }
  
  public void a(bkjt parambkjt)
  {
    if (parambkjt == null) {
      return;
    }
    this.jdField_a_of_type_Bkjt = parambkjt;
    b(parambkjt.b);
    c(parambkjt.jdField_a_of_type_JavaLangString);
    d(parambkjt.c);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 29;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bkjt == null)
    {
      localObject = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        break label70;
      }
      QLog.e("IliveGroupTipsBar", 1, "ilvie group bar click null , url = " + (String)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.jdField_a_of_type_Bkjt.d;
      break;
      label70:
      IliveShareHelper.reportAction("qq_live", "live_group_page", "live_group", "group_bar", "4", 102, IliveShareHelper.getFollowInfo("", "", "", "", ""));
      if (URLUtil.isNetworkUrl((String)localObject))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
        localIntent.addFlags(268435456);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      }
      else
      {
        localObject = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject);
        if (localObject != null) {
          ((bfvp)localObject).a();
        } else if (QLog.isColorLevel()) {
          QLog.d("IliveGroupTipsBar", 2, "onEditorAction jumpUrl is illegal");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjo
 * JD-Core Version:    0.7.0.1
 */