import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class bhua
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  private int c;
  
  private bhua(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    Friends localFriends = ((anyw)paramQQAppInterface.getManager(51)).e(paramString1);
    int i;
    if (localFriends != null)
    {
      if (!bhty.a(localFriends.nameplateVipType)) {
        break label166;
      }
      paramQQAppInterface = bhtz.a(localFriends.nameplateVipType);
      if (!bhty.b(localFriends.grayNameplateFlag)) {
        break label116;
      }
      i = 1;
      this.c = i;
      this.jdField_a_of_type_Int = paramQQAppInterface.jdField_a_of_type_Int;
      if ((paramQQAppInterface != bhtz.f) && (paramQQAppInterface != bhtz.g)) {
        break label122;
      }
      this.jdField_b_of_type_Int = localFriends.bigClubTemplateId;
      this.jdField_a_of_type_Boolean = true;
    }
    label116:
    label122:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        if ((paramQQAppInterface == bhtz.d) || (paramQQAppInterface == bhtz.e))
        {
          this.jdField_b_of_type_Int = localFriends.superVipTemplateId;
          return;
        }
      } while ((paramQQAppInterface != bhtz.b) && (paramQQAppInterface != bhtz.c));
      this.jdField_b_of_type_Int = 0;
      return;
      i = VipUtils.a(paramQQAppInterface, paramString1);
      paramString2 = null;
      if (i >> 8 == 3) {
        paramString2 = EVIPSPEC.E_SP_BIGCLUB;
      }
      while (paramString2 == EVIPSPEC.E_SP_BIGCLUB)
      {
        this.jdField_a_of_type_Int = VipUtils.a(paramQQAppInterface, paramString1, EVIPSPEC.E_SP_BIGCLUB);
        this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int >> 8 | (this.jdField_a_of_type_Int & 0xF) << 8);
        this.jdField_b_of_type_Int = localFriends.bigClubTemplateId;
        this.jdField_a_of_type_Boolean = true;
        return;
        if (i >> 8 == 1) {
          paramString2 = EVIPSPEC.E_SP_QQVIP;
        } else if (i >> 8 == 2) {
          paramString2 = EVIPSPEC.E_SP_SUPERVIP;
        }
      }
      if (paramString2 == EVIPSPEC.E_SP_SUPERVIP)
      {
        this.jdField_a_of_type_Int = VipUtils.a(paramQQAppInterface, paramString1, EVIPSPEC.E_SP_SUPERVIP);
        this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int >> 8 | (this.jdField_a_of_type_Int & 0xF) << 8);
        this.jdField_b_of_type_Int = localFriends.superVipTemplateId;
        return;
      }
    } while (paramString2 != EVIPSPEC.E_SP_QQVIP);
    label166:
    this.jdField_a_of_type_Int = VipUtils.a(paramQQAppInterface, paramString1, EVIPSPEC.E_SP_QQVIP);
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int >> 8 | (this.jdField_a_of_type_Int & 0xF) << 8);
    this.jdField_b_of_type_Int = 0;
  }
  
  public static bhua a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return new bhua(paramQQAppInterface, paramString1, paramString2);
  }
  
  public void a()
  {
    String str = this.jdField_b_of_type_JavaLangString;
    int i = this.jdField_b_of_type_Int;
    if (this.c != 0) {}
    for (boolean bool = true;; bool = false)
    {
      bhty.a(str, i, bool);
      return;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!bict.a.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "namePlate_UrlConfig")) {
      bict.a.download(null, "namePlate_UrlConfig", null, false);
    }
    Object localObject1;
    int i;
    boolean bool;
    if ((paramMotionEvent == null) || (paramMotionEvent.getAction() == 1))
    {
      paramMotionEvent = bict.a.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c);
      localObject1 = this.jdField_b_of_type_JavaLangString;
      i = this.jdField_b_of_type_Int;
      if (this.c == 0) {
        break label234;
      }
      bool = true;
      bhty.b((String)localObject1, i, bool);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool = this.jdField_a_of_type_JavaLangString.equals(localObject1);
      if ((paramMotionEvent == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        break label339;
      }
      if (!"VIA_SETTINGME".equals(this.jdField_b_of_type_JavaLangString)) {
        break label240;
      }
      paramMotionEvent = paramMotionEvent.d;
    }
    for (;;)
    {
      label142:
      if (!TextUtils.isEmpty(paramMotionEvent))
      {
        if (bool) {
          break label748;
        }
        paramMotionEvent = paramMotionEvent.replace("{uin}", this.jdField_a_of_type_JavaLangString);
      }
      label234:
      label748:
      for (;;)
      {
        Object localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("portraitOnly", true);
        ((Intent)localObject2).putExtra("uin", (String)localObject1);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        VasWebviewUtil.openQQBrowserWithoutAD(paramView.getContext(), paramMotionEvent, 256L, (Intent)localObject2, false, -1);
        return true;
        bool = false;
        break;
        label240:
        if ("VIA_PROFILECARD".equals(this.jdField_b_of_type_JavaLangString))
        {
          if (bool)
          {
            paramMotionEvent = paramMotionEvent.e;
            break label142;
          }
          paramMotionEvent = paramMotionEvent.g;
          break label142;
        }
        if ("VIA_AIO_TITLE".equals(this.jdField_b_of_type_JavaLangString))
        {
          if (bool)
          {
            paramMotionEvent = paramMotionEvent.f;
            break label142;
          }
          paramMotionEvent = paramMotionEvent.h;
          break label142;
        }
        if (!"VIA_AIO_CHATSETTINGS".equals(this.jdField_b_of_type_JavaLangString)) {
          break label751;
        }
        if (bool)
        {
          paramMotionEvent = paramMotionEvent.i;
          break label142;
        }
        paramMotionEvent = paramMotionEvent.j;
        break label142;
        if ("VIA_SETTINGME".equals(this.jdField_b_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_Boolean)
          {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, "cty");
            return true;
          }
          VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), "cty");
          return true;
        }
        if ("VIA_PROFILECARD".equals(this.jdField_b_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_Boolean)
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject1 = paramView.getContext();
            i = this.jdField_a_of_type_Int;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (bool) {}
            for (paramView = "zlk";; paramView = "zlkkr")
            {
              VipUtils.a(paramMotionEvent, (Context)localObject1, i, (String)localObject2, paramView);
              return true;
            }
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject1 = paramView.getContext();
          if (bool) {}
          for (paramView = "zlk";; paramView = "zlkkr")
          {
            VipUtils.b(paramMotionEvent, (Context)localObject1, paramView);
            return true;
          }
        }
        if ("VIA_AIO_TITLE".equals(this.jdField_b_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_Boolean)
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject1 = paramView.getContext();
            i = this.jdField_a_of_type_Int;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (bool) {}
            for (paramView = "ctoc";; paramView = "ctockr")
            {
              VipUtils.a(paramMotionEvent, (Context)localObject1, i, (String)localObject2, paramView);
              return true;
            }
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject1 = paramView.getContext();
          if (bool) {}
          for (paramView = "ctoc";; paramView = "ctockr")
          {
            VipUtils.b(paramMotionEvent, (Context)localObject1, paramView);
            return true;
          }
        }
        if ("VIA_AIO_CHATSETTINGS".equals(this.jdField_b_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_Boolean)
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject1 = paramView.getContext();
            i = this.jdField_a_of_type_Int;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (bool) {}
            for (paramView = "ctocset";; paramView = "ctocsetkr")
            {
              VipUtils.a(paramMotionEvent, (Context)localObject1, i, (String)localObject2, paramView);
              return true;
            }
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject1 = paramView.getContext();
          if (bool) {}
          for (paramView = "ctocset";; paramView = "ctocsetkr")
          {
            VipUtils.b(paramMotionEvent, (Context)localObject1, paramView);
            return true;
          }
        }
        if (this.jdField_a_of_type_Boolean)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, "unknow");
          return true;
        }
        VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), "unknow");
        return true;
      }
      label339:
      label751:
      paramMotionEvent = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhua
 * JD-Core Version:    0.7.0.1
 */