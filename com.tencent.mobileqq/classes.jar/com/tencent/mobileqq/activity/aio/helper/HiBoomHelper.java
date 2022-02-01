package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.graphics.Paint;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.api.HiBoomForwardAuthObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class HiBoomHelper
  implements ILifeCycleHelper, AbsListView.OnScrollListener
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  private HiBoomForwardAuthObserver jdField_a_of_type_ComTencentMobileqqHiboomApiHiBoomForwardAuthObserver;
  
  public HiBoomHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && (localBaseChatPie.a != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomApiHiBoomForwardAuthObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.removeObserver(this.jdField_a_of_type_ComTencentMobileqqHiboomApiHiBoomForwardAuthObserver);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8008C70", "0X8008C70", ZhituManager.a(paramInt), 0, "", "", "", "");
    paramString = HiBoomConstants.a(paramString);
    if ((paramString != null) && (paramString.length() > 20))
    {
      QQToast.a(paramContext, HardCodeUtil.a(2131705557), 0).a();
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800932C", "0X800932C", 0, 0, "", "", "", "");
      return false;
    }
    return true;
  }
  
  private void b()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && (localBaseChatPie.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getHiBoomAuthObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqHiboomApiHiBoomForwardAuthObserver = new HiBoomForwardAuthObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.addObserver(this.jdField_a_of_type_ComTencentMobileqqHiboomApiHiBoomForwardAuthObserver);
    }
  }
  
  private void c()
  {
    com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
  }
  
  public boolean a(Context paramContext, String paramString, EditTextUI paramEditTextUI)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(paramEditTextUI.a());
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramEditTextUI.a());
    return (paramString.length() < 200) && (!paramString.contains("\n")) && ((int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString) + AIOUtils.b(45.0F, paramContext.getResources()) + paramEditTextUI.b() < paramEditTextUI.h());
  }
  
  public String getTag()
  {
    return "HiBoomHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 10 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 10)
      {
        if (paramInt != 15) {
          return;
        }
        a();
        return;
      }
      c();
      return;
    }
    b();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((paramAbsListView != null) && (paramAbsListView.a != null)) {
        ((IFontManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getRuntimeService(IFontManagerService.class, "")).resumeFontAnimation(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
    }
    else if (!PicItemBuilder.j)
    {
      com.etrump.mixlayout.api.ETFontUtil.enableAnimation = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HiBoomHelper
 * JD-Core Version:    0.7.0.1
 */