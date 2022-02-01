package com.tencent.biz.troop.file;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.troop.file.protocol.TroopFileCreateFolderObserver;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileListObserver;
import com.tencent.biz.widgets.InputDialog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class MoveFileActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  int jdField_a_of_type_Int = 0;
  protected long a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MoveFileActivity.FolderListAdapter jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity$FolderListAdapter = new MoveFileActivity.FolderListAdapter(this, null);
  private TroopFileCreateFolderObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileCreateFolderObserver = new MoveFileActivity.8(this);
  private TroopFileGetFileListObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFileListObserver = new MoveFileActivity.3(this);
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = ByteStringMicro.copyFromUtf8("");
  private TroopFileManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected String a;
  private ArrayList<TroopFileInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 15;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString;
  private int e = 0;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", MoveFileActivity.class.getName());
    localIntent.putExtra("troop_uin", paramString1);
    paramContext = paramString2;
    if (paramString2 == null) {
      paramContext = "/";
    }
    localIntent.putExtra("folder_id", paramContext);
    localIntent.putExtra("file_id", paramString3);
    localIntent.putExtra("file_name", paramString4);
    return localIntent;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = this.jdField_b_of_type_JavaLangString.equals("/");
    boolean bool1 = true;
    if (!bool2)
    {
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private void c()
  {
    a();
  }
  
  public void a()
  {
    TroopFileProtocol.a(this.app, this.jdField_a_of_type_Long, this.jdField_d_of_type_Int, 0, this.jdField_c_of_type_Int, 3, 1, "/", 1, 0L, this.e, this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFileListObserver);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, localException.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = InputDialog.a(this, paramString1, "", 2131690728, 2131691064, new MoveFileActivity.4(this), new MoveFileActivity.5(this));
    paramString2 = paramString1.getEditText();
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2.setText(paramString3);
    }
    paramString2.setFilters(new InputFilter[] { new InputFilter.LengthFilter(48) });
    paramString2.setHint(2131697619);
    paramString2.addTextChangedListener(new MoveFileActivity.6(this, paramString2, paramString1));
    if (!TextUtils.isEmpty(paramString4)) {
      paramString1.a(paramString4, -65536);
    }
    paramString1.getBtnight().setEnabled(false);
    paramString1.getBtnight().setTextColor(getResources().getColor(2131165606));
    paramString1.show();
    new Handler(getMainLooper()).post(new MoveFileActivity.7(this, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719249);
    Drawable localDrawable = getResources().getDrawable(2130839401);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    ((Animatable)localDrawable).start();
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, localException.toString());
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    Object localObject = paramBundle.getString("troop_uin");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_Long = Long.valueOf((String)localObject).longValue();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("folder_id");
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      finish();
      return false;
    }
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("file_name");
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      finish();
      return false;
    }
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("file_id");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager = TroopFileManager.a(this.app, this.jdField_a_of_type_Long);
    paramBundle = (LayoutInflater)getSystemService("layout_inflater");
    localObject = paramBundle.inflate(2131560647, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject).findViewById(2131365037));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131365318);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131365081));
    localTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    setContentView((View)localObject);
    setTitle(2131697609);
    localTextView = (TextView)findViewById(2131369233);
    localTextView.setText(2131690728);
    localTextView.setOnClickListener(this);
    localTextView.setVisibility(0);
    this.leftView.setVisibility(8);
    localObject = (TextView)((View)localObject).findViewById(2131366819);
    TextUtils.ellipsize(this.jdField_d_of_type_JavaLangString, ((TextView)localObject).getPaint(), AIOUtils.b(230.0F, getResources()), TextUtils.TruncateAt.MIDDLE, false, new MoveFileActivity.1(this, (TextView)localObject));
    this.jdField_a_of_type_AndroidViewView = paramBundle.inflate(2131560652, null);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131373862).setBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373863));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity$FolderListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity$FolderListAdapter);
    c();
    ReportController.b(this.app, "P_CliOper", "Grp_files", "", "file", "move_file", 0, 0, Long.toString(this.jdField_a_of_type_Long), "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    TroopFileInfo localTroopFileInfo;
    if (i != 2131365081)
    {
      if (i != 2131365318)
      {
        if (i == 2131369233)
        {
          ReportController.b(this.app, "P_CliOper", "Grp_files", "", "file", "move_cancel", 0, 0, Long.toString(this.jdField_a_of_type_Long), "", "", "");
          finish();
          overridePendingTransition(0, 2130772015);
        }
      }
      else if (TroopFileUtils.a(this.app, this, this.jdField_a_of_type_Long) != 0) {
        a(getResources().getString(2131697539), null, this.jdField_a_of_type_JavaLangString, "");
      }
    }
    else
    {
      localTroopFileInfo = (TroopFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
      if (this.jdField_b_of_type_JavaLangString.equals(localTroopFileInfo.jdField_b_of_type_JavaLangString))
      {
        finish();
        overridePendingTransition(0, 2130772015);
      }
    }
    try
    {
      if (TroopFileUtils.a(this.app, this, this.jdField_a_of_type_Long) != 0)
      {
        TroopFileProtocol.a(this.app, this.jdField_a_of_type_Long, localTroopFileInfo.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, localTroopFileInfo.jdField_b_of_type_JavaLangString, new MoveFileActivity.2(this, localTroopFileInfo));
        a(2131697610);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label227:
      break label227;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == this.jdField_b_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839301);
    this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(getActivity(), 2131755543);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity$FolderListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity
 * JD-Core Version:    0.7.0.1
 */