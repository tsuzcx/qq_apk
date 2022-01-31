package com.tencent.biz.qqstory.pgc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqGetSearchFeedList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetSearchFeedList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.SearchType;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.UserInfo;
import com.tencent.biz.qqstory.pgc.adapter.PgcSearchResultAdapter;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import nhy;
import nhz;
import nia;
import nib;
import nic;
import nid;
import nie;

public class QQStoryDiscoverSearchDialog
  extends Dialog
  implements View.OnClickListener
{
  public int a;
  public Activity a;
  public View a;
  public EditText a;
  public ImageButton a;
  public LinearLayout a;
  public TextView a;
  public PgcSearchResultAdapter a;
  public QQStoryPullToRefreshListView a;
  protected AppInterface a;
  public String a;
  public TextView b;
  public String b;
  
  public QQStoryDiscoverSearchDialog(AppInterface paramAppInterface, Activity paramActivity, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this(paramAppInterface, paramActivity, paramBoolean, paramOnCancelListener, null);
  }
  
  public QQStoryDiscoverSearchDialog(AppInterface paramAppInterface, Activity paramActivity, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, String paramString)
  {
    super(paramActivity, paramBoolean, paramOnCancelListener);
    this.jdField_a_of_type_Int = 0;
    super.setCanceledOnTouchOutside(true);
    super.requestWindowFeature(1);
    super.getWindow().setSoftInputMode(36);
    super.setContentView(2130970797);
    paramOnCancelListener = super.getWindow().getAttributes();
    paramOnCancelListener.x = 0;
    paramOnCancelListener.y = 0;
    paramOnCancelListener.width = -1;
    paramOnCancelListener.windowAnimations = 16973824;
    paramOnCancelListener.gravity = 51;
    paramOnCancelListener.dimAmount = 0.0F;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    b();
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371932));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371933));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371934));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368323));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369816);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368322));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint("搜索认证帐号或栏目");
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new nhy(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    Button localButton = (Button)findViewById(2131368321);
    localButton.setVisibility(0);
    localButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterPgcSearchResultAdapter = new PgcSearchResultAdapter(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)findViewById(2131365669));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterPgcSearchResultAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(new nhz(this));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnTouchListener(new nia(this));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new nib(this));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.a(new nic(this));
    StoryReportor.a("search", "clk", 0, 0, new String[0]);
  }
  
  public void a()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, String paramString, List paramList, boolean paramBoolean)
  {
    if ((paramAppInterface == null) || (!(paramAppInterface instanceof AppInterface)) || (paramContext == null)) {}
    while ((!paramBoolean) && (TextUtils.isEmpty(paramString))) {
      return;
    }
    qqstory_pgc.ReqGetSearchFeedList localReqGetSearchFeedList = new qqstory_pgc.ReqGetSearchFeedList();
    localReqGetSearchFeedList.key_word.set(ByteStringMicro.copyFromUtf8(paramString), true);
    localReqGetSearchFeedList.type_list.set(paramList);
    localReqGetSearchFeedList.ignore_keyword.set(paramBoolean);
    paramContext = new NewIntent(paramContext.getApplicationContext(), ProtoServlet.class);
    paramContext.putExtra("cmd", QQStoryHandler.j);
    paramContext.putExtra("data", localReqGetSearchFeedList.toByteArray());
    paramContext.setObserver(new nie(this));
    paramAppInterface.startServlet(paramContext);
  }
  
  public void a(Object paramObject)
  {
    int j = 2;
    int m = 1;
    int k = 1;
    int i;
    ArrayList localArrayList;
    Object localObject2;
    if (QQStoryHandler.a(paramObject))
    {
      try
      {
        localObject1 = new qqstory_pgc.RspGetSearchFeedList();
        ((qqstory_pgc.RspGetSearchFeedList)localObject1).mergeFrom((byte[])paramObject);
        paramObject = (qqstory_pgc.ErrorInfo)((qqstory_pgc.RspGetSearchFeedList)localObject1).result.get();
        i = paramObject.error_code.get();
        paramObject.error_desc.get().toStringUtf8();
        if (i != 0) {
          break label477;
        }
        if (((qqstory_pgc.RspGetSearchFeedList)localObject1).result_type.has()) {
          j = ((qqstory_pgc.RspGetSearchFeedList)localObject1).result_type.get();
        }
        paramObject = ((qqstory_pgc.RspGetSearchFeedList)localObject1).feed_list.get();
        localArrayList = new ArrayList();
        paramObject = paramObject.iterator();
        i = 0;
        if (paramObject.hasNext())
        {
          localObject2 = UserInfo.convertFrom((qqstory_pgc.UserInfo)paramObject.next());
          if ((localObject2 == null) || (!((UserInfo)localObject2).checkData()))
          {
            QQStoryManager.c("QQStoryHandler handleGetPGCSearchFeedList user=" + localObject2);
            i = 1;
            break label521;
          }
          localArrayList.add(localObject2);
          break label521;
        }
        if (i == 0) {
          break label359;
        }
        StoryReportor.b("story_check", "pgc_check", 0, 1, new String[] { QQStoryHandler.j });
        if (!((qqstory_pgc.RspGetSearchFeedList)localObject1).is_end.has()) {
          break label535;
        }
        i = ((qqstory_pgc.RspGetSearchFeedList)localObject1).is_end.get();
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        Object localObject1;
        label245:
        i = 0;
      }
      if (!((qqstory_pgc.RspGetSearchFeedList)localObject1).next_cookie.has()) {
        break label546;
      }
    }
    label521:
    label535:
    label540:
    label546:
    for (paramObject = ((qqstory_pgc.RspGetSearchFeedList)localObject1).next_cookie.get().toStringUtf8();; paramObject = null)
    {
      localObject2 = new ArrayList();
      if (((qqstory_pgc.RspGetSearchFeedList)localObject1).key_word_list.has())
      {
        localObject1 = ((qqstory_pgc.RspGetSearchFeedList)localObject1).key_word_list.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((List)localObject2).add(((ByteStringMicro)((Iterator)localObject1).next()).toStringUtf8());
          continue;
          label340:
          paramObject.printStackTrace();
        }
      }
      for (;;)
      {
        if (i == 0) {
          a(false, 0, null, false, null, null);
        }
        return;
        label359:
        StoryReportor.b("story_check", "pgc_check", 0, 0, new String[] { QQStoryHandler.j });
        break;
        a(true, j, localArrayList, bool, paramObject, (List)localObject2);
        i = m;
        try
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleGetPGCSearchFeedList isSuccess=" + true + " userInfoList:" + localArrayList + " isEnd:" + bool + " nextCookie:" + paramObject);
          i = m;
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          i = k;
        }
        break label340;
        label477:
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleGetPGCSearchFeedList error_code=" + paramObject.error_code.get());
        }
        i = 0;
      }
      break;
      for (;;)
      {
        if (i != 1) {
          break label540;
        }
        bool = true;
        break;
        i = 0;
      }
      boolean bool = false;
      break label245;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList1, boolean paramBoolean2, String paramString, List paramList2)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.search", 2, "QQStoryDiscoverActivity is Finished");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.discoverHall", 2, "onGetPGCSearchFeedList: isSuccess = " + paramBoolean1);
      }
    } while (paramInt != 2);
    if (paramBoolean1)
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      if (paramList1.size() != 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterPgcSearchResultAdapter.b(paramList1);
          this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterPgcSearchResultAdapter.a(paramList2);
          StoryReportor.a("search", "effect", 1, 0, new String[0]);
          label150:
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a(paramBoolean1);
          paramList1 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a;
          if (paramBoolean2) {
            break label404;
          }
        }
      }
    }
    label404:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      paramList1.a(paramBoolean1, paramBoolean2);
      return;
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterPgcSearchResultAdapter.c(paramList1);
      break;
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("未搜索到相关结果");
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841332), null, null);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterPgcSearchResultAdapter.a();
        StoryReportor.a("search", "invalid", 1, 0, new String[0]);
      }
      if (!QLog.isColorLevel()) {
        break label150;
      }
      QLog.d("Q.qqstory.search", 2, "muti-search:onGetPGCSearchFeedList empty result");
      break label150;
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterPgcSearchResultAdapter.a();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败，点击重试");
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130838592), null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new nid(this));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!QLog.isColorLevel()) {
        break label150;
      }
      QLog.d("Q.qqstory.search", 2, "muti-search:onGetPGCSearchFeedList failed");
      break label150;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      paramString = new ArrayList();
      qqstory_pgc.SearchType localSearchType = new qqstory_pgc.SearchType();
      localSearchType.search_type.set(0);
      localSearchType.start_cookie.set(ByteStringMicro.copyFromUtf8(""));
      localSearchType.search_count.set(0);
      paramString.add(localSearchType);
      localSearchType = new qqstory_pgc.SearchType();
      localSearchType.search_type.set(1);
      localSearchType.start_cookie.set(ByteStringMicro.copyFromUtf8(str));
      localSearchType.search_count.set(10);
      paramString.add(localSearchType);
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, paramString, false);
      bool = true;
    }
    do
    {
      return bool;
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("当前网络不可用，请检查你的网络设置");
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843505), null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return false;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a(false);
        return false;
      }
    } while (this.jdField_a_of_type_Int != 2);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.a(false, false);
    return false;
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368323: 
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(4);
      return;
    case 2131368321: 
      cancel();
      return;
    }
    StoryReportor.a("search", "clk_all", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.pgc.QQStoryDiscoverSearchDialog
 * JD-Core Version:    0.7.0.1
 */