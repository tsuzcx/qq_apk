import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper.1;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendLabelFlowLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aryi
  extends arwe
  implements View.OnClickListener, arqv, bkhe
{
  protected static String a;
  protected static boolean a;
  protected static int b;
  protected static boolean b;
  protected static int c;
  protected int a;
  protected View a;
  protected ViewGroup a;
  protected TextView a;
  protected arwf a;
  protected ExtendFriendLabelFlowLayout a;
  protected ListView a;
  protected List<String> a;
  protected View b;
  protected ViewGroup b;
  protected View c;
  protected boolean c;
  protected int d;
  View d;
  
  static
  {
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 1;
  }
  
  public aryi()
  {
    super(null);
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  public aryi(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  public void A()
  {
    if ((this.jdField_a_of_type_Arwf != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null) && ((this.jdField_a_of_type_Arwf instanceof arzm)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      ((arzm)this.jdField_a_of_type_Arwf).a(i, j);
    }
  }
  
  protected void B()
  {
    if (a()) {
      if (d()) {
        arze.a("0X800AE31", 0);
      }
    }
    while (!b())
    {
      return;
      arze.a("0X800AE22", 0);
      return;
    }
    c("0X800AE38");
  }
  
  public int a()
  {
    return 1;
  }
  
  protected int a(int paramInt)
  {
    return bgtn.a(paramInt);
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController == null) {
      return BaseApplicationImpl.sApplication;
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext;
  }
  
  protected Drawable a(int paramInt)
  {
    if (ThemeUtil.isNowThemeIsNight(a(), false, null)) {}
    for (String str = "#1C1C1C";; str = "#F5F6FA") {
      return bgtn.a(Color.parseColor(str), bgtn.a(paramInt));
    }
  }
  
  @NonNull
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    this.jdField_a_of_type_AndroidViewView = View.inflate(a(), 2131559128, null);
    a(this.jdField_a_of_type_AndroidViewView);
    Object localObject = aqol.a();
    if (localObject != null)
    {
      localObject = ((aqom)localObject).jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      if ((localObject != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(new aryk(this, a(), this.jdField_a_of_type_JavaUtilList));
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label162;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelHotPicSearchHelper", 4, "emoticonTags is null. ");
        }
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_JavaUtilList = Arrays.asList(a().getResources().getStringArray(2130968579));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(new aryk(this, a(), this.jdField_a_of_type_JavaUtilList));
      break;
      label162:
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 4, "emoticonTags size: " + this.jdField_a_of_type_JavaUtilList.size());
      }
    }
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController == null) {
      return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public String a()
  {
    return "EmoticonPanelHotPicSearchHelper";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController == null) {
      return;
    }
    ((aryb)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(1)).m();
  }
  
  public void a(int paramInt)
  {
    u();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController != null)
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(12);
      if (EmoticonPanelController.jdField_b_of_type_Int == paramInt) {
        A();
      }
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(2131366856));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131370184));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379883));
    ImageView localImageView = (ImageView)paramView.findViewById(2131369274);
    Button localButton = (Button)paramView.findViewById(2131363718);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366687));
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131376766);
    this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(a(18));
    this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundDrawable(a(18));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (ThemeUtil.isNowThemeIsNight(a(), false, null)) {}
    for (paramView = "#B0B3BF";; paramView = "#03081A")
    {
      localTextView.setTextColor(Color.parseColor(paramView));
      localImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      localButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      c(jdField_b_of_type_Int);
      return;
    }
  }
  
  public void a(arqt paramarqt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "onSearchCallBack ");
    }
    if ((this.jdField_a_of_type_Arwf == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null))
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (paramarqt == null)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "onSearchCallBack result： " + paramarqt.a());
    }
    if ((paramarqt.a() == -101) || (paramarqt.a() == -103))
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    ThreadManager.getUIHandler().post(new EmoticonPanelHotPicSearchHelper.1(this, paramarqt));
  }
  
  protected void a(QQAppInterface paramQQAppInterface, arqu paramarqu, arqv paramarqv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "pushEmotionSearchTask ");
    }
    paramQQAppInterface = (arqs)paramQQAppInterface.getManager(367);
    paramQQAppInterface.b();
    paramQQAppInterface.a(paramarqv);
    paramQQAppInterface.a(paramarqu);
  }
  
  public void a(EmotionPanelListView paramEmotionPanelListView)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      paramEmotionPanelListView.removeHeaderView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      paramEmotionPanelListView.removeFooterView(this.jdField_b_of_type_AndroidViewView);
    }
  }
  
  public void a(EmotionPanelListView paramEmotionPanelListView, arwf paramarwf, int paramInt)
  {
    if ((paramEmotionPanelListView != null) && (paramInt == 14))
    {
      b(paramEmotionPanelListView, paramarwf);
      paramarwf = a();
      if ((paramarwf.getParent() == null) && (paramEmotionPanelListView.findHeaderViewPosition(paramarwf) == -1)) {
        paramEmotionPanelListView.addHeaderView(paramarwf);
      }
      paramarwf = b();
      if (paramarwf.getParent() == null) {
        paramEmotionPanelListView.addFooterView(paramarwf);
      }
    }
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    if (jdField_a_of_type_Boolean) {
      o();
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    arze.a(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "onHide.");
    }
    jdField_c_of_type_Int = a();
    v();
  }
  
  protected boolean a()
  {
    return (a() == 1) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(12) == EmoticonPanelController.jdField_b_of_type_Int);
  }
  
  public int[] a()
  {
    return new int[] { 8, 4, 5, 3 };
  }
  
  protected View b()
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = View.inflate(a(), 2131558611, null);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, bgtn.a(74.0F)));
    }
    p();
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public String b()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController == null) {
      return;
    }
    ((aryb)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(1)).n();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(View paramView)
  {
    this.jdField_c_of_type_AndroidViewView = paramView;
  }
  
  public void b(arqt paramarqt)
  {
    if ((this.jdField_a_of_type_Arwf == null) || (paramarqt == null)) {
      return;
    }
    int i;
    if (paramarqt.a() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, "onSearchCallBack success isHasMore: " + paramarqt.a());
      }
      Object localObject = paramarqt.a();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if ((d()) && (a())) {
          arze.a("0X800AE2B", 0);
        }
        b(8);
        this.jdField_a_of_type_Arwf.a(new ArrayList());
        m();
        o();
        p();
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmotionSearchItem localEmotionSearchItem = (EmotionSearchItem)((Iterator)localObject).next();
        localArrayList.add(new asbg(a(), localArrayList.size() + 1, b(), localEmotionSearchItem));
      }
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 5)) {
        y();
      }
      if (paramarqt.a())
      {
        i = 1;
        b(i);
        o();
        p();
        this.jdField_a_of_type_Arwf.a(localArrayList);
        m();
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
      i = 3;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, "onSearchCallBack fail");
      }
      c(paramarqt);
    }
  }
  
  protected void b(ListView paramListView, arwf paramarwf)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Arwf = paramarwf;
  }
  
  protected void b(String paramString)
  {
    bcst.b(a(), "dc00898", "", "", paramString, paramString, 0, 0, "2", "", "", "");
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected boolean b()
  {
    int i = bgsg.aK(a(), a().getCurrentAccountUin());
    return (a() == 2) && (i == 5);
  }
  
  public void c()
  {
    jdField_a_of_type_JavaLangString = null;
  }
  
  public void c(int paramInt)
  {
    if ((QLog.isColorLevel()) && (jdField_b_of_type_Int != paramInt)) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "setSearchContainerVisibility visibility= " + paramInt + " mLoadingStatus: " + this.jdField_a_of_type_Int);
    }
    jdField_b_of_type_Int = paramInt;
    if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      if (TextUtils.isEmpty(b()))
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(paramInt);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(paramInt);
  }
  
  protected void c(arqt paramarqt)
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 5)) {
      b(4);
    }
    for (;;)
    {
      o();
      m();
      p();
      return;
      if ((paramarqt.a() == -102) || (paramarqt.a() == -100)) {
        b(7);
      } else if (paramarqt.a() == -104) {
        b(3);
      } else {
        b(2);
      }
    }
  }
  
  protected void c(String paramString)
  {
    bcst.b(a(), "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  protected boolean c()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if ("EmoticonPanelHotPicSearchHelper".equals(a()))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      if (localLayoutParams == null) {
        return true;
      }
      i = localLayoutParams.topMargin;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.getVisibility() != 0)) {
        break label106;
      }
    }
    label106:
    for (localLayoutParams.topMargin = (bgtn.a(60.0F) + this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.getHeight());; localLayoutParams.topMargin = bgtn.a(60.0F))
    {
      if (localLayoutParams.topMargin != i) {
        this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
      return false;
    }
  }
  
  public void d(String paramString)
  {
    jdField_b_of_type_Boolean = false;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Arwf == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "startSearch.");
    }
    a(paramString);
    this.jdField_a_of_type_Arwf.a(new ArrayList());
    t();
    a();
  }
  
  public boolean d()
  {
    return !bgsp.a(b());
  }
  
  public void f()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "onShow ");
    }
    int i;
    if ((jdField_c_of_type_Int != a()) || (a() == 2))
    {
      i = 1;
      if (i == 0)
      {
        i = j;
        if (jdField_c_of_type_Int != a())
        {
          i = j;
          if (!a()) {}
        }
      }
      else
      {
        i = 1;
      }
      if ((i != 0) && (this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_Arwf != null))
      {
        if (!TextUtils.isEmpty(b())) {
          break label102;
        }
        s();
      }
    }
    label102:
    boolean bool;
    do
    {
      return;
      i = 0;
      break;
      bool = jdField_a_of_type_Boolean;
      w();
    } while (bool);
    t();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "onDestory.");
    }
    v();
    c();
    l();
    jdField_b_of_type_Int = 0;
    jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Arwf = null;
    this.jdField_a_of_type_ComTencentWidgetListView = null;
  }
  
  protected void l()
  {
    arqs.a(a()).b();
  }
  
  protected void m()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) || (this.jdField_c_of_type_AndroidViewView == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, "updateLoadingView.");
      }
    } while (c());
    TextView localTextView = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365899);
    View localView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365910);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    if ((this.jdField_a_of_type_Int == 4) && ((bgtn.a(XPanelContainer.b()) < XPanelContainer.jdField_a_of_type_Int) || ("RichTextPanelEmoticonSearchLayoutHelper".equals(a()))))
    {
      localView.setVisibility(8);
      localTextView.setText(2131689857);
      localTextView.setOnClickListener(this);
      n();
      return;
    }
    if (this.jdField_a_of_type_Int == 5)
    {
      localView.setVisibility(0);
      localTextView.setText(2131689852);
      B();
      return;
    }
    if (this.jdField_a_of_type_Int == 8)
    {
      localView.setVisibility(8);
      localTextView.setText(2131689855);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void n()
  {
    if (b()) {
      c("0X800AE39");
    }
    while (!a()) {
      return;
    }
    if (d())
    {
      arze.a("0X800AE32", 0);
      return;
    }
    arze.a("0X800AE23", 0);
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "notifyHeaderViewChange loadingStatus:" + this.jdField_a_of_type_Int);
    }
    if (TextUtils.isEmpty(b()))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(0);
    }
    for (;;)
    {
      c(jdField_b_of_type_Int);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(b());
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.clearFocus();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController != null)
      {
        c();
        Rect localRect = new Rect();
        this.jdField_a_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(true, localRect.bottom, true, null, this.jdField_d_of_type_AndroidViewView.getWidth());
        continue;
        c();
        b();
        s();
        a("0X800AE30", 0);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController != null)
        {
          a("0X800AE2F", 0);
          localRect = new Rect();
          this.jdField_b_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(true, localRect.bottom, false, null, this.jdField_b_of_type_AndroidViewViewGroup.getWidth());
          b("0X800AE1E");
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController != null)
          {
            localRect = new Rect();
            this.jdField_a_of_type_AndroidWidgetTextView.getGlobalVisibleRect(localRect);
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(true, localRect.bottom, false, b(), this.jdField_d_of_type_AndroidViewView.getWidth());
            continue;
            if (this.jdField_a_of_type_Int == 4)
            {
              r();
              x();
            }
            else
            {
              b(1);
              p();
              q();
              continue;
              r();
              x();
            }
          }
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    while ((paramInt1 + paramInt2 < paramInt3) || (this.jdField_a_of_type_Int != 1) || (this.jdField_c_of_type_Boolean)) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (((paramAbsListView instanceof EmotionPanelListView)) && (this.jdField_d_of_type_Int == 2)) {
      ((EmotionPanelListView)paramAbsListView).abordFling();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    q();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  protected void p()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "notifyFooterViewChange.");
    }
    TextView localTextView1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368100);
    localTextView1.setTextSize(12.0F);
    View localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131368099);
    TextView localTextView2 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370226);
    localTextView2.setTextSize(12.0F);
    localTextView1.setOnClickListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = a(74);
    if (localLayoutParams.height != i)
    {
      localLayoutParams.height = i;
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 0))
    {
      localView.setVisibility(0);
      localTextView2.setText(2131689852);
      localTextView1.setVisibility(4);
      B();
      return;
    }
    if (this.jdField_a_of_type_Int == 7)
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(2131689856);
      localView.setVisibility(4);
      n();
      return;
    }
    if ((this.jdField_a_of_type_Int == 2) || ((this.jdField_a_of_type_Int == 4) && (a(XPanelContainer.b()) >= XPanelContainer.jdField_a_of_type_Int) && ("EmoticonPanelHotPicSearchHelper".equals(a()))))
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(2131689857);
      localView.setVisibility(4);
      n();
      return;
    }
    localTextView1.setVisibility(8);
    localView.setVisibility(8);
    localLayoutParams.height = -2;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  protected void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "start onLoadMore");
    }
    if (b()) {
      c("0X800AE37");
    }
    for (;;)
    {
      arqs.a(a()).a();
      return;
      if (a()) {
        if (d()) {
          arze.a("0X800AE2C", 0);
        } else {
          arze.a("0X800AE21", 0);
        }
      }
    }
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "start loadPicData word is null: " + TextUtils.isEmpty(b()) + " sPrepareSearch: " + jdField_b_of_type_Boolean);
    }
    if (TextUtils.isEmpty(b())) {
      s();
    }
    do
    {
      return;
      if (!jdField_b_of_type_Boolean)
      {
        w();
        t();
        return;
      }
    } while (this.jdField_a_of_type_Int == 5);
    b(5);
    o();
    p();
    m();
    w();
  }
  
  protected void s()
  {
    b(0);
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    v();
    c();
    p();
    o();
    m();
    u();
    arqu localarqu = new arqu(0);
    a(a(), localarqu, this);
  }
  
  public void t()
  {
    if (TextUtils.isEmpty(b())) {
      return;
    }
    if ((d()) && (a())) {
      arze.a("0X800AE2A", 0);
    }
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    v();
    b(5);
    p();
    o();
    u();
    m();
    arqu localarqu = new arqu(1, b());
    a(a(), localarqu, this);
  }
  
  protected void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController == null) {
      return;
    }
    if ((a()) && (!TextUtils.isEmpty(b())))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.r();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setLeftScrollDisEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setRightScrollDisEnable(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.s();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Aryw.b(EmoticonPanelController.jdField_b_of_type_Int);
  }
  
  protected void v()
  {
    if ((this.jdField_a_of_type_Arwf instanceof arzm)) {
      ((arzm)this.jdField_a_of_type_Arwf).d();
    }
  }
  
  public void w()
  {
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      a();
    }
  }
  
  protected void x()
  {
    if (b()) {
      c("0X800AE3A");
    }
    while (!a()) {
      return;
    }
    if (d())
    {
      arze.a("0X800AE33", 0);
      return;
    }
    arze.a("0X800AE24", 0);
  }
  
  protected void y()
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(new aryj(this));
  }
  
  public void z()
  {
    jdField_b_of_type_Boolean = true;
    b(5);
    if (this.jdField_a_of_type_Arwf != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
      this.jdField_a_of_type_Arwf.a(new ArrayList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryi
 * JD-Core Version:    0.7.0.1
 */