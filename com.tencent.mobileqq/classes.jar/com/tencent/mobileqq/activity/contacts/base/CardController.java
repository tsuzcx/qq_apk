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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import wji;

public class CardController
  extends BaseViewController
  implements HeadCardAdapter.HeadAdapterCallback, SlideCardView.CardsSlideListener
{
  public int a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private HeadCardAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter;
  private final CardViewController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController;
  private final HonestSayController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController;
  private SlideCardView jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView;
  public QQAppInterface a;
  protected ConfessObserver a;
  private final boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[2];
  private int b;
  private int c = -1;
  
  public CardController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver = new wji(this);
    if ((paramActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)paramActivity).app;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController = new CardViewController(paramActivity, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController = new HonestSayController(paramActivity, this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ((ConfessHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125)).a(5, true, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
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
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    int i = this.c;
    this.c = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(paramInt);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBoolean.length) || (paramInt == 1)) {
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131363895));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView = ((SlideCardView)paramView.findViewById(2131363896));
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
  }
  
  public void a(List paramList)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(1, false, paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter);
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (paramList.size() > 0) {
        bool1 = true;
      }
    }
    a(1, bool1);
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
      a(0, false);
      a(1, false);
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
        if (((CommonCardEntry)localObject).jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController.a((CommonCardEntry)localObject);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController.b(paramBoolean);
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
    a(1, false);
    a(0, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHonestSayController.d();
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