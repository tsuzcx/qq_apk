package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ClickedWaveView.OnTouchReceive;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class PokePanel
  extends RelativeLayout
  implements View.OnClickListener, ClickedWaveView.OnTouchReceive, AbsListView.OnScrollListener
{
  public static boolean c = false;
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private PokePanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioPokePanelAdapter;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver = new PokePanel.4(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new PokePanel.3(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<int[]> jdField_a_of_type_JavaUtilArrayList;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131720492, 2130839161, 3 };
  int jdField_b_of_type_Int = 1;
  long jdField_b_of_type_Long = 0L;
  public boolean b;
  private final int[] jdField_b_of_type_ArrayOfInt = { 2131694947, 2130839121, 1 };
  private final int[] c;
  private boolean jdField_d_of_type_Boolean = false;
  private final int[] jdField_d_of_type_ArrayOfInt = { 2131693132, 2130839159, 4 };
  private boolean jdField_e_of_type_Boolean = false;
  private final int[] jdField_e_of_type_ArrayOfInt = { 2131693139, 2130839160, 5 };
  private final int[] f = { 2131693055, 2130839122, 6 };
  
  public PokePanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2131692933, 2130839119, 2 };
  }
  
  public PokePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2131692933, 2130839119, 2 };
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_c_of_type_Boolean) {
      ThreadManager.excute(new PokePanel.1(paramQQAppInterface), 64, null, true);
    }
  }
  
  private void a(ArrayList<PokePanel.PokeData> paramArrayList)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      int[] arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i);
      PokePanel.PokeData localPokeData = new PokePanel.PokeData();
      if ((arrayOfInt[2] == 1) && (!PokeItemHelper.b(arrayOfInt[2])))
      {
        localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838112);
      }
      else if ((arrayOfInt[2] != 0) && (PokeItemHelper.b(arrayOfInt[2])))
      {
        switch (arrayOfInt[2])
        {
        default: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("/chuo_icon/chuo_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 6: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("/dazhao_icon/dazhao_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 5: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("/666_icon/666_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 4: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("/xinsui_icon/xinsui_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 3: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("/zan_icon/zan_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 2: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("/bixin_icon/bixin_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 1: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(PokeItemAnimationManager.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("/chuo_icon/chuo_icon_");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        Object localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inSampleSize = 1;
        ((BitmapFactory.Options)localObject2).inMutable = true;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("01.png");
        localObject2 = ImageUtil.a(localStringBuilder.toString(), (BitmapFactory.Options)localObject2);
        localObject2 = new CustomFrameAnimationDrawable(BaseApplicationImpl.getContext().getResources(), (Bitmap)localObject2, this.jdField_a_of_type_MqqOsMqqHandler);
        int k;
        for (int j = 0; j < 22; j = k)
        {
          k = j + 1;
          if (k < 10)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("0");
            localStringBuilder.append(k);
            localStringBuilder.append(".png");
            ((CustomFrameAnimationDrawable)localObject2).a(j, 40, localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(k);
            localStringBuilder.append(".png");
            ((CustomFrameAnimationDrawable)localObject2).a(j, 40, localStringBuilder.toString());
          }
        }
        localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject2);
      }
      else
      {
        localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(arrayOfInt[1]);
      }
      localPokeData.jdField_a_of_type_Int = arrayOfInt[2];
      localPokeData.jdField_b_of_type_Int = arrayOfInt[1];
      localPokeData.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]));
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131708322));
      localPokeData.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
      localPokeData.jdField_b_of_type_Boolean = false;
      paramArrayList.add(localPokeData);
      i += 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_c_of_type_Boolean) {
      return true;
    }
    if ((PokeItemHelper.b(2)) && (PokeItemHelper.b(3)) && (PokeItemHelper.b(4)) && (PokeItemHelper.b(5)) && (PokeItemHelper.b(6)) && (PokeBigResHandler.a()))
    {
      PokeItemHelper.a(paramQQAppInterface, null);
      jdField_c_of_type_Boolean = true;
      return true;
    }
    Object localObject = (IEarlyDownloadService)paramQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
    if (localObject != null)
    {
      localObject = (PokeResHandler)((IEarlyDownloadService)localObject).getEarlyHandler("qq.android.poke.res_0625");
      paramQQAppInterface = (PokeBigResHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER);
      if (localObject != null) {
        ((PokeResHandler)localObject).a(true);
      }
      if ((paramQQAppInterface != null) && (!PokeBigResHandler.a())) {
        paramQQAppInterface.a(true);
      }
    }
    jdField_c_of_type_Boolean = false;
    return false;
  }
  
  private void b(Bundle paramBundle)
  {
    int j = paramBundle.getInt("type");
    int i = paramBundle.getInt("id");
    Object localObject = paramBundle.getString("name");
    String str = paramBundle.getString("minVersion");
    int k = paramBundle.getInt("feeType");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("panel sendPokeMsg type:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      QLog.d("PokeMsg", 2, new Object[] { localStringBuilder.toString(), Integer.valueOf(1) });
    }
    switch (i)
    {
    }
    for (;;)
    {
      break;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 3, "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 3, 0, "", "", "", "");
      continue;
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = SystemClock.currentThreadTimeMillis();
      }
      else
      {
        if (SystemClock.currentThreadTimeMillis() - this.jdField_a_of_type_Long < 500L) {
          return;
        }
        this.jdField_a_of_type_Long = SystemClock.currentThreadTimeMillis();
      }
      this.jdField_a_of_type_Long = SystemClock.currentThreadTimeMillis();
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 5, "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 5, 0, "", "", "", "");
      break;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 4, 0, "", "", "", "");
      break;
      if (this.jdField_b_of_type_Long == 0L)
      {
        this.jdField_b_of_type_Long = SystemClock.currentThreadTimeMillis();
      }
      else
      {
        if (SystemClock.currentThreadTimeMillis() - this.jdField_b_of_type_Long < 500L) {
          return;
        }
        this.jdField_b_of_type_Long = SystemClock.currentThreadTimeMillis();
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 6, "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 6, 0, "", "", "", "");
      break;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 1, 0, "", "", "", "");
      break;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 2, "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F22", "0X8007F22", 2, 0, "", "", "", "");
    }
    if (126 == j)
    {
      if (paramBundle.getBoolean("isShowLoading"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.PokePanel", 2, "poke item is downloading, do nothing");
        }
        return;
      }
      if (paramBundle.getBoolean("isShowDownload"))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanelAdapter.a("poke.item.res.", i, true, false);
        paramBundle = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
        if (!PokeItemHelper.a("effect.gif", i))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("poke.item.effect.");
          ((StringBuilder)localObject).append(i);
          paramBundle.downloadItem(21L, ((StringBuilder)localObject).toString(), "clickDownload");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("poke.item.res.");
        ((StringBuilder)localObject).append(i);
        paramBundle.downloadItem(21L, ((StringBuilder)localObject).toString(), "clickDownload");
        paramBundle.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
        return;
      }
      if (!PokeItemHelper.jdField_a_of_type_Boolean)
      {
        PokeItemHelper.jdField_a_of_type_Boolean = true;
        PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject, k, str, 0);
      }
    }
  }
  
  private void b(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      switch (paramString.charAt(i))
      {
      default: 
        break;
      case '6': 
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        break;
      case '5': 
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_ArrayOfInt);
        break;
      case '4': 
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_d_of_type_ArrayOfInt);
        break;
      case '3': 
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ArrayOfInt);
        break;
      case '2': 
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_ArrayOfInt);
        break;
      case '1': 
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ArrayOfInt);
      }
      i += 1;
    }
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(Bundle paramBundle)
  {
    if (!this.jdField_e_of_type_Boolean) {
      b(paramBundle);
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131368373));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
    paramBaseChatPie = getResources().getDrawable(2130850615);
    if ((paramBaseChatPie instanceof BitmapDrawable))
    {
      paramSessionInfo = (BitmapDrawable)paramBaseChatPie;
      paramSessionInfo.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      paramSessionInfo.setDither(true);
      setBackgroundDrawable(paramBaseChatPie);
    }
    else if ((paramBaseChatPie instanceof SkinnableBitmapDrawable))
    {
      paramSessionInfo = (SkinnableBitmapDrawable)paramBaseChatPie;
      paramSessionInfo.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      paramSessionInfo.setDither(true);
      setBackgroundDrawable(paramBaseChatPie);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    } else {
      localArrayList.clear();
    }
    localArrayList = new ArrayList();
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("PokePanelAnimThread", 0);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "[pokepanel]reload()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanelAdapter = new PokePanelAdapter(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanelAdapter);
    ThreadManager.getFileThreadHandler().post(new PokePanel.2(this, paramString, localArrayList));
  }
  
  public void b()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanelAdapter.a();
      Object localObject2;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PokePanel.PokeData)((Iterator)localObject1).next();
          if ((((PokePanel.PokeData)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable)((PokePanel.PokeData)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable).j();
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ondestroy err ");
      ((StringBuilder)localObject2).append(localException);
      QLog.d("Q.aio.PokePanel", 1, ((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
      ((IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanelAdapter.a();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PokePanel.PokeData localPokeData = (PokePanel.PokeData)((Iterator)localObject).next();
          if ((localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable)localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable).l();
          }
        }
      }
    }
    ((PokeBigResHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER)).a(false);
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanelAdapter;
      if (localObject != null)
      {
        this.jdField_a_of_type_Boolean = true;
        localObject = ((PokePanelAdapter)localObject).a();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PokePanel.PokeData localPokeData = (PokePanel.PokeData)((Iterator)localObject).next();
            if ((localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable)) {
              ((CustomFrameAnimationDrawable)localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable).k();
            }
          }
        }
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    this.jdField_e_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanel
 * JD-Core Version:    0.7.0.1
 */