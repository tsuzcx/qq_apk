package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.adapter.HeadCardAdapter;
import com.tencent.mobileqq.activity.contacts.adapter.HeadCardAdapter.HeadAdapterCallback;
import com.tencent.mobileqq.activity.contacts.view.card.SlideCardView;
import com.tencent.mobileqq.activity.contacts.view.card.SlideCardView.CardsSlideListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessObserver;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.ExtendFriendConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import wmn;

public class CardController
  extends BaseViewController
  implements HeadCardAdapter.HeadAdapterCallback, SlideCardView.CardsSlideListener
{
  public int a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private HeadCardAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter;
  private final CardViewController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController;
  private final ExtendFriendController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseExtendFriendController;
  private final HonestSayController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController;
  private SlideCardView jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView;
  public QQAppInterface a;
  protected ConfessObserver a;
  private final boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[3];
  private int b;
  private int c = -1;
  
  public CardController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver = new wmn(this);
    if ((paramActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)paramActivity).app;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController = new CardViewController(paramActivity, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController = new HonestSayController(paramActivity, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseExtendFriendController = new ExtendFriendController(paramActivity, this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ((ConfessHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125)).a(5, true, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(paramInt);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseExtendFriendController.a();
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    int i = this.c;
    this.c = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.b(paramInt);
    if (this.c != i) {
      a(i, this.c);
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardController", 2, String.format("mSlideCardView showing index=%d curType=%d oldType=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.c), Integer.valueOf(i) }));
    }
  }
  
  public void a(int paramInt, CommonCardEntry paramCommonCardEntry)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBoolean.length) || (paramInt == 2)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(paramInt, true, paramCommonCardEntry);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter);
    if (paramCommonCardEntry != null) {}
    for (;;)
    {
      a(paramInt, bool);
      return;
      bool = false;
    }
  }
  
  public void a(int paramInt1, CommonCardEntry paramCommonCardEntry, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter == null) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfBoolean.length) || (paramInt1 == 2)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(paramInt1, paramCommonCardEntry, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter);
    if (paramCommonCardEntry != null) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt1, bool);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfBoolean.length)) {
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = paramBoolean;
    }
    paramInt = 0;
    int i = 0;
    while (paramInt < this.jdField_a_of_type_ArrayOfBoolean.length)
    {
      i |= this.jdField_a_of_type_ArrayOfBoolean[paramInt];
      paramInt += 1;
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      if (i == 0) {
        break label86;
      }
    }
    label86:
    for (paramInt = j;; paramInt = 8)
    {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != paramInt) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(paramInt);
      }
      return;
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131363918));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView = ((SlideCardView)paramView.findViewById(2131363919));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.setInterceptListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.setCardsSlideListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter = new HeadCardAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter = new HeadCardAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseExtendFriendController.a(paramQQAppInterface);
  }
  
  public void a(List paramList)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(2, false, paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter);
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (paramList.size() > 0) {
        bool1 = true;
      }
    }
    a(2, bool1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController.a(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.a(this.b);
    }
  }
  
  public boolean a(int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < this.jdField_a_of_type_ArrayOfBoolean.length) {
        i = this.jdField_a_of_type_ArrayOfBoolean[paramInt];
      }
    }
    return i;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseExtendFriendController.b();
  }
  
  public void b(int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007F17", "0X8007F17", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter == null) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(paramInt);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CardController", 2, String.format(Locale.getDefault(), "clearCardRecord something error currentIndex = %s", new Object[] { Integer.valueOf(paramInt) }));
    return;
    if (paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a() - 1)
    {
      a(1, false);
      a(2, false);
      a(0, false);
    }
    if ((localObject instanceof MayKnowRecommend)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController.a((MayKnowRecommend)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CardController", 2, String.format("onCardVanish index=%d", new Object[] { Integer.valueOf(paramInt) }));
      }
      if (paramInt != this.b) {
        break;
      }
      paramInt = this.c;
      this.c = -1;
      a(paramInt, this.c);
      return;
      if ((localObject instanceof CommonCardEntry))
      {
        localObject = (CommonCardEntry)localObject;
        if (((CommonCardEntry)localObject).jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController.a((CommonCardEntry)localObject);
        } else if (((CommonCardEntry)localObject).jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseExtendFriendController.a((CommonCardEntry)localObject);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController.b(paramBoolean);
    ExtendFriendManager.ExtendFriendConfig localExtendFriendConfig = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a();
    if ((localExtendFriendConfig != null) && (localExtendFriendConfig.g == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController.b(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseExtendFriendController.b(paramBoolean);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseExtendFriendController.b(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController.b(paramBoolean);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.setAdapter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseExtendFriendController.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.setAdapter(null);
    }
    a(2, false);
    a(1, false);
    a(0, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseExtendFriendController.d();
  }
  
  public void d(boolean paramBoolean)
  {
    SlideCardView localSlideCardView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView != null)
    {
      localSlideCardView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView;
      if (paramBoolean) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      localSlideCardView.setColorTheme(bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(paramBoolean);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.CardController
 * JD-Core Version:    0.7.0.1
 */