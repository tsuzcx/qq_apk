package com.tencent.av.wtogether.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter;
import com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter.FileSelectListener;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.handler.WatchTogetherHandler;
import com.tencent.av.wtogether.observer.WatchTogetherObserver;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.ISearchable;
import com.tencent.mobileqq.search.SearchTask;
import com.tencent.mobileqq.search.SearchTask.SearchTaskCallBack;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.widget.CountdownTimeTask;
import com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView;
import com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;

public class GroupFileSearchDialog
  extends Dialog
  implements Handler.Callback, View.OnClickListener, GroupFileSearchExpandableListAdapter.FileSelectListener, SearchTask.SearchTaskCallBack
{
  protected int a;
  protected long a;
  protected Activity a;
  protected Handler a;
  protected ViewGroup a;
  protected Button a;
  protected EditText a;
  protected ImageButton a;
  protected RelativeLayout a;
  protected TextView a;
  protected GroupFileSearchExpandableListAdapter a;
  private ChooseFileInfo jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = new ChooseFileInfo(1);
  protected WatchTogetherObserver a;
  private GroupFileSearchDialog.ClickListener jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog$ClickListener;
  public GroupFileViewMoreRelativeLayout a;
  protected BizTroopObserver a;
  protected QQAppInterface a;
  protected SearchTask a;
  protected CountdownTimeTask a;
  protected PinnedHeaderIphoneTreeView a;
  protected QQBlurView a;
  protected Object a;
  protected String a;
  protected List<IContactSearchable> a;
  protected boolean a;
  protected int b;
  protected long b;
  protected TextView b;
  protected String b;
  protected List<TroopFileSearchItemData> b;
  protected boolean b;
  protected boolean c = false;
  protected boolean d = false;
  protected boolean e = false;
  protected boolean f = false;
  
  public GroupFileSearchDialog(Activity paramActivity, QQAppInterface paramQQAppInterface, long paramLong, GroupFileSearchDialog.ClickListener paramClickListener)
  {
    super(paramActivity, 2131755540);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new GroupFileSearchDialog.6(this);
    this.jdField_a_of_type_ComTencentAvWtogetherObserverWatchTogetherObserver = new GroupFileSearchDialog.7(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    a(paramActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376483));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView = ((PinnedHeaderIphoneTreeView)findViewById(2131377082));
    findViewById(2131377089).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131370362));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370364));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379865));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368340));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131381023));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog$ClickListener = paramClickListener;
    a();
    e();
    b(paramActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvWtogetherObserverWatchTogetherObserver);
    ThreadManager.post(new GroupFileSearchDialog.1(this), 8, null, true);
  }
  
  private void a(ListView paramListView)
  {
    Object localObject = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((RelativeLayout)localObject).addView(new View(this.jdField_a_of_type_AndroidAppActivity), new RelativeLayout.LayoutParams(-1, AIOUtils.b(50.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
    paramListView.addFooterView((View)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131380356));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(paramListView);
    paramListView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    paramListView.b(paramListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    paramListView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    paramListView.setEnableBlur(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130850581);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    Button localButton = (Button)findViewById(2131363868);
    localButton.setVisibility(0);
    localButton.setOnClickListener(this);
  }
  
  protected float a()
  {
    float f2 = this.jdField_a_of_type_AndroidWidgetEditText.getWidth() - DisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    float f1 = f2;
    if (this.jdField_b_of_type_Int > 0) {
      f1 = f2 - (this.jdField_a_of_type_AndroidWidgetEditText.getPaint().measureText(a(this.jdField_b_of_type_Int)) + DisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F));
    }
    f2 = f1;
    if (this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() == 0) {
      f2 = f1 - (this.jdField_a_of_type_AndroidWidgetImageButton.getWidth() + DisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F));
    }
    return f2;
  }
  
  protected String a(int paramInt)
  {
    if (paramInt > 1000) {
      return this.jdField_a_of_type_AndroidAppActivity.getString(2131697362);
    }
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131697361, new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected String a(String paramString)
  {
    float f1 = a();
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (localTextPaint.measureText(paramString) <= f1) {
        return paramString;
      }
      paramString = new StringBuilder(paramString.substring(0, localTextPaint.breakText(paramString, true, f1 - localTextPaint.measureText("…"), null)));
      paramString.append("…");
      str = paramString.toString();
    }
    return str;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new GroupFileSearchDialog.4(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new GroupFileSearchDialog.5(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public void a(int paramInt, List<? extends ISearchable> paramList)
  {
    if (paramInt == 1)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      paramList.clear();
    }
  }
  
  protected void a(Activity paramActivity)
  {
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    if (!VersionUtils.e()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    } else {
      getWindow().setBackgroundDrawable(new ColorDrawable(paramActivity.getResources().getColor(2131165700)));
    }
    setContentView(2131559878);
    findViewById(2131381019).setVisibility(0);
    findViewById(2131370406).setBackgroundResource(2130838739);
    findViewById(2131370406).setOnClickListener(this);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    localLayoutParams.width = -1;
    localLayoutParams.windowAnimations = 16973824;
    localLayoutParams.gravity = 51;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      new SystemBarCompact(this, true, paramActivity.getResources().getColor(2131167114)).init();
      paramActivity = (LinearLayout)findViewById(2131370406);
      paramActivity.setFitsSystemWindows(true);
      paramActivity.setPadding(0, ImmersiveUtils.getScreenHeight(), 0, 0);
    }
  }
  
  public final void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_Int;
        if (i > 0) {
          return;
        }
        if (TextUtils.isEmpty(paramString1))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("GroupFileSearchDialog", 4, "doReqTroopFileSearch err marchWord is null--------------");
          }
        }
        else
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Int += 1;
          paramQQAppInterface = (WatchTogetherHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QAV_WT_HANDLER);
          if (paramString2 == null) {
            break label99;
          }
          paramQQAppInterface.a(paramLong, ByteStringMicro.copyFromUtf8(paramString2), paramString1);
        }
        return;
      }
      finally {}
      label99:
      paramString2 = "";
    }
  }
  
  public void a(TroopFileSearchItemData paramTroopFileSearchItemData)
  {
    if (paramTroopFileSearchItemData != null)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_b_of_type_Long = paramTroopFileSearchItemData.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_c_of_type_Int = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_Int;
      localObject = this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo;
      ((ChooseFileInfo)localObject).jdField_a_of_type_JavaLangString = "/";
      ((ChooseFileInfo)localObject).jdField_b_of_type_JavaLangString = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_c_of_type_JavaLangString = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_d_of_type_Long = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_d_of_type_JavaLangString = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_c_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select file ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
      QLog.d("GroupFileSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetButton;
    boolean bool;
    if (paramTroopFileSearchItemData != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((Button)localObject).setEnabled(bool);
  }
  
  protected void a(String paramString)
  {
    try
    {
      boolean bool = this.d;
      if (bool) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.cancel(true);
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask = null;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask = new SearchTask(paramString, paramString, this.jdField_a_of_type_JavaUtilList, this);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.a();
      return;
    }
    finally {}
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int <= 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    long l = System.currentTimeMillis();
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    float f1 = a() - localTextPaint.measureText(paramString);
    if (f1 < 0.0F)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("resetResultNumTextVisible compareWidth = ");
      paramString.append(f1);
      paramString.append(", time = ");
      paramString.append(System.currentTimeMillis() - l);
      QLog.e("zivonchen", 2, paramString.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130839401, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694879);
      localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[0];
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setVisibility(0);
      localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[0];
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131694424));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  protected void b(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout = new GroupFileViewMoreRelativeLayout(paramActivity);
    this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout.setBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout.setTextColor(paramActivity.getResources().getColor(2131167056));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.addFooterView(this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout);
    this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter = new GroupFileSearchExpandableListAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView, this.jdField_a_of_type_AndroidOsHandler, this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setAdapter(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setOnScrollListener(new GroupFileSearchDialog.2(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setOnTouchListener(new GroupFileSearchDialog.3(this));
  }
  
  public void b(boolean paramBoolean)
  {
    a(false);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131697357, new Object[] { this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843892, 0, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setVisibility(0);
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[0];
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    CountdownTimeTask localCountdownTimeTask = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask;
    if (localCountdownTimeTask != null)
    {
      localCountdownTimeTask.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.getFirstVisiblePosition() == 0)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout.setText(2131719254);
      this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout.a();
      return;
    }
    this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout.setText(2131694879);
    this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileViewMoreRelativeLayout.setTextLeftDrawable(2130839401);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.e = true;
      String str = a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
      }
    }
  }
  
  public void dismiss()
  {
    this.d = true;
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    SingleLineHotwordTextView.a();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask;
    if (localObject != null)
    {
      ((CountdownTimeTask)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask;
    if (localObject != null) {
      ((SearchTask)localObject).cancel(true);
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter;
    if (localObject != null)
    {
      ((GroupFileSearchExpandableListAdapter)localObject).b();
      this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvWtogetherObserverWatchTogetherObserver);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.d) {
      return true;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return false;
            }
            a(false);
            a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), true);
            if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            }
            if (this.c) {
              this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.a();
            }
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = false;
              InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
            }
            c(this.f);
            this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.notifyDataSetChanged();
            if (this.c)
            {
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.setSelectedGroup(0);
              this.c = false;
            }
            long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
            paramMessage = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().toLowerCase();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("REFRESH_LIST text = ");
              localStringBuilder.append(paramMessage);
              localStringBuilder.append(", lastHotword = ");
              localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
              localStringBuilder.append(", time = ");
              localStringBuilder.append(l);
              QLog.e("zivonchen", 2, localStringBuilder.toString());
            }
            if ((!paramMessage.equals(this.jdField_a_of_type_JavaLangString)) && (l >= 800L))
            {
              this.jdField_b_of_type_JavaLangString = null;
              this.c = true;
              this.jdField_a_of_type_JavaLangString = paramMessage;
              a(this.jdField_a_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
              return false;
            }
          }
          else
          {
            b(false);
            return false;
          }
        }
        else
        {
          b(true);
          return false;
        }
      }
      else
      {
        a(false);
        return false;
      }
    }
    else {
      a(true);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131381023: 
      paramView = this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog$ClickListener;
      if (paramView != null)
      {
        paramView.b(this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
        return;
      }
      break;
    case 2131368340: 
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      c();
      return;
    case 2131363868: 
    case 2131370406: 
      dismiss();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog
 * JD-Core Version:    0.7.0.1
 */