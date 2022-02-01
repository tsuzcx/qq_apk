import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anpu
  extends anqh
  implements View.OnClickListener
{
  public static long a;
  public static boolean a;
  private int jdField_a_of_type_Int = -1;
  private amrk jdField_a_of_type_Amrk = new amrk(-1, -1);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private SparseArray<SparseArray<ApolloGameRedDot>> jdField_a_of_type_AndroidUtilSparseArray;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private anpz jdField_a_of_type_Anpz;
  private blhb jdField_a_of_type_Blhb;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public ApolloGameData a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private WeakReference<anqd> jdField_a_of_type_JavaLangRefWeakReference;
  int[] jdField_a_of_type_ArrayOfInt = { 1002, 1001, 1000, 1005 };
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private List<ApolloGameData> jdField_b_of_type_JavaUtilList;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private List<ApolloGameRankData> jdField_c_of_type_JavaUtilList;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private ImageView e;
  private int g;
  
  public anpu(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_c_of_type_Int = 100;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.g = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramQQAppInterface);
    paramContext = ApolloGameUtil.a();
    if ((paramContext != null) && (paramContext.getBoolean("sp.aio.show", true))) {}
    for (;;)
    {
      jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[initView] panelView=", paramView, ", mGameRootView=", this.jdField_a_of_type_AndroidViewViewGroup });
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != paramView)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367535));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365139));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368402));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368392));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368422));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368403));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368401));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131365135));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364007));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364051));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131364052));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363838));
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365148));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131373236));
      this.e = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373239));
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      this.e.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    }
  }
  
  private void a(ApolloGameData paramApolloGameData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[onGameItemClick] gameInfo=", paramApolloGameData });
    }
    if (paramApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onGameItemClick] gameInfo null");
      return;
    }
    Object localObject1;
    if (paramApolloGameData.isSetting) {
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        localObject1 = anka.T;
        if (!TextUtils.isEmpty(paramApolloGameData.toolUrl)) {
          localObject1 = paramApolloGameData.toolUrl;
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if ("1".equals(Uri.parse((String)localObject1).getQueryParameter("useApolloBrowser")))
        {
          ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, null, "aio", (String)localObject1, null);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          i = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (!a()) {
            break label760;
          }
          paramApolloGameData = "0";
          if (!ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label259;
          }
          localObject1 = "0";
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "clk_more_game_enter", i, 0, new String[] { paramApolloGameData, localObject1 });
          return;
        }
      }
      catch (Throwable paramApolloGameData)
      {
        QLog.e("ApolloGameViewBinder", 1, paramApolloGameData, new Object[] { "[onGameItemClick]" });
        return;
      }
      paramApolloGameData = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramApolloGameData.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, -1L, paramApolloGameData, false, -1);
      continue;
      label259:
      localObject1 = "1";
      continue;
      QLog.e("ApolloGameViewBinder", 1, "[onGameItemClick] empty context");
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1036)
      {
        localObject1 = ((amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
        if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
        {
          localObject2 = new anqd(this);
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject2);
          ((amuf)localObject1).a((amuh)localObject2);
        }
        ((anqd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
        if (!paramApolloGameData.isGameApp)
        {
          ((amuf)localObject1).a(paramApolloGameData.gameId, ((anqd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramApolloGameData.gameId) == null) || (((SparseArray)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramApolloGameData.gameId)).size() <= 0)) {
            break label755;
          }
          localObject1 = (SparseArray)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramApolloGameData.gameId);
          if (((SparseArray)localObject1).get(2000) != null)
          {
            ((SparseArray)localObject1).remove(2000);
            ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramApolloGameData.gameId, 2000);
            if (this.jdField_a_of_type_Anpz != null) {
              this.jdField_a_of_type_Anpz.notifyDataSetChanged();
            }
          }
        }
      }
      label545:
      label747:
      label755:
      for (int i = 1;; i = 0)
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        int j = this.g;
        int k = paramApolloGameData.gameId;
        if (i != 0)
        {
          localObject1 = "1";
          if (paramApolloGameData.type != 2) {
            break label747;
          }
        }
        for (localObject2 = "1";; localObject2 = "0")
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_game_banner", j, 0, new String[] { String.valueOf(k), localObject1, localObject2, String.valueOf(paramApolloGameData.tagType) });
          return;
          amub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramApolloGameData, ((anqd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Int);
          break;
          j = paramApolloGameData.gameId;
          k = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
          int m = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
          if (a()) {}
          for (i = 317;; i = 100)
          {
            localObject1 = new CmGameStartChecker.StartCheckParam(j, true, "launch", 0L, 0, 0, k, m, (String)localObject1, i, null);
            ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentContext, (CmGameStartChecker.StartCheckParam)localObject1);
            break;
          }
          localObject1 = "0";
          break label545;
        }
      }
      label760:
      paramApolloGameData = "1";
    }
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      e();
      QLog.e("ApolloGameViewBinder", 1, "[showNoGameRoleDialog] gameData null");
      return;
    }
    if (TextUtils.isEmpty(paramApolloGameData.gameAppid))
    {
      e();
      QLog.e("ApolloGameViewBinder", 1, "[showNoGameRoleDialog] gameAppid null");
      return;
    }
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690094)).setPositiveButton(2131690082, new anpx(this, paramApolloGameData)).setNegativeButton(2131690083, new anpw(this)).show();
  }
  
  private void c(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      e();
      QLog.e("ApolloGameViewBinder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690084)).setPositiveButton(2131690083, new anpy(this)).show();
  }
  
  private void e()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131699850), 0).a();
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, "[createPanelView]");
    }
    Object localObject1;
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[createPanelView] context null");
      localObject1 = null;
    }
    Object localObject2;
    TextView localTextView;
    do
    {
      return localObject1;
      switch (this.jdField_b_of_type_Int)
      {
      default: 
        localObject1 = (ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558682, null);
        localObject2 = (XListView)((ViewGroup)localObject1).findViewById(2131367535);
        return localObject1;
      }
      localObject2 = (ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558687, null);
      localTextView = (TextView)((ViewGroup)localObject2).findViewById(2131372016);
      if (amma.a())
      {
        localTextView.setOnClickListener(null);
        localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690105));
        return localObject2;
      }
      localObject1 = localObject2;
    } while (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext));
    localTextView.setText(anvx.a(2131699880));
    localTextView.setOnClickListener(new anpv(this));
    return localObject2;
  }
  
  public ApolloGameData a()
  {
    ApolloGameData localApolloGameData = new ApolloGameData();
    localApolloGameData.gameId = 2147483647;
    localApolloGameData.isShow = 1;
    localApolloGameData.name = amsn.a("aio.enter.name");
    localApolloGameData.listCoverUrl = amsn.a("aio.enter.bg");
    localApolloGameData.isSetting = true;
    localApolloGameData.toolUrl = amsn.a("aio.enter");
    return localApolloGameData;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 0)) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Anpz != null) {
      this.jdField_a_of_type_Anpz.a();
    }
    if ((a()) && (amma.a("apollo_aio_game_guide") == -1))
    {
      amma.a("apollo_aio_game_guide", 1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, "[onDestroy] from destory");
      }
    }
    if (this.jdField_a_of_type_Blhb != null) {}
    try
    {
      this.jdField_a_of_type_Blhb.dismiss();
      this.jdField_a_of_type_Blhb = null;
      QLog.i("ApolloGameViewBinder", 1, "onDestroy CmGameTempSessionHandler");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        anqd localanqd = (anqd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localanqd != null)
        {
          ((amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a().b(localanqd);
          this.jdField_a_of_type_JavaLangRefWeakReference = null;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloGameViewBinder", 1, localThrowable, new Object[] { "[onPanelClose] dissmiss window " });
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updateProgress] progress=", Integer.valueOf(paramInt) });
    }
    if (paramInt < 100)
    {
      if (this.jdField_d_of_type_AndroidViewViewGroup != null) {
        this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt < 100);
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(100);
      }
    } while (this.jdField_d_of_type_AndroidViewViewGroup == null);
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void a(amrk paramamrk)
  {
    if (QLog.isColorLevel()) {
      if (paramamrk != null) {
        break label41;
      }
    }
    label41:
    for (int i = -1;; i = paramamrk.jdField_a_of_type_Int)
    {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[setJumpGameId] jumpGameId=", Integer.valueOf(i) });
      this.jdField_a_of_type_Amrk = paramamrk;
      return;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updatePanel] panelView=", paramView, ", pageIndex=", Integer.valueOf(paramInt) });
    }
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, "[updatePanel] panelView null");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_Int == 8);
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameViewBinder", 2, "[updatePanel] no game data");
    return;
    a(paramView);
    paramInt = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updatePanel] gameCoinCount=", Integer.valueOf(paramInt) });
    }
    if (paramInt > 9999) {}
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    this.e.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, "[updatePanel] prepare list data");
    }
    if (this.jdField_a_of_type_Anpz == null) {
      this.jdField_a_of_type_Anpz = new anpz(this.jdField_a_of_type_AndroidContentContext, this);
    }
    this.jdField_a_of_type_Anpz.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Anpz);
    if ((this.jdField_a_of_type_Amrk != null) && (this.jdField_a_of_type_Amrk.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_JavaUtilList.size() > 1))
    {
      paramView = this.jdField_b_of_type_JavaUtilList.iterator();
      while (paramView.hasNext()) {
        if (((ApolloGameData)paramView.next()).gameId == this.jdField_a_of_type_Amrk.jdField_a_of_type_Int)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updatePanel] jump gameId:", Integer.valueOf(this.jdField_a_of_type_Amrk.jdField_a_of_type_Int), ",from:", Integer.valueOf(this.jdField_a_of_type_Amrk.jdField_b_of_type_Int) });
          }
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "avatar_clk_togame", this.g, this.jdField_a_of_type_Amrk.jdField_b_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_Amrk.jdField_a_of_type_Int) });
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, "[updatePanel] show game list");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void a(List<ApolloGameData> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[setGameList] list=", paramList });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1036) && (paramList != null) && (amsn.a("aio.city.game", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == amso.d)) {
      paramList.add(0, a());
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidUtilSparseArray = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      int i = 0;
      while ((this.jdField_b_of_type_JavaUtilList != null) && (i < this.jdField_b_of_type_JavaUtilList.size()))
      {
        paramList = (ApolloGameData)this.jdField_b_of_type_JavaUtilList.get(i);
        if (paramList != null)
        {
          SparseArray localSparseArray = (SparseArray)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramList.gameId);
          if ((localSparseArray != null) && (localSparseArray.size() > 0))
          {
            localSparseArray.remove(1001);
            if (TextUtils.isEmpty(paramList.toolUrl)) {
              localSparseArray.remove(1002);
            }
          }
        }
        i += 1;
      }
    }
    this.jdField_c_of_type_JavaUtilList = ((ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).h(6);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloPanel.a() == 7);
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ??? = (ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      if (TextUtils.isEmpty(a())) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        this.jdField_c_of_type_JavaUtilList = ((ankc)???).a(ApolloGameUtil.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      }
      if ((this.jdField_c_of_type_JavaUtilList != null) && (paramInt > 0))
      {
        Object localObject3;
        synchronized (this.jdField_c_of_type_JavaUtilList)
        {
          ArrayList localArrayList = new ArrayList();
          localObject3 = this.jdField_c_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            ApolloGameRankData localApolloGameRankData = (ApolloGameRankData)((Iterator)localObject3).next();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGameViewBinder", 2, new Object[] { "[hasRankIcon] t ", localApolloGameRankData });
            }
            String str = a();
            if ((localApolloGameRankData != null) && (!TextUtils.isEmpty(str)) && (localApolloGameRankData.isInvalid()) && (localApolloGameRankData.mGameId == paramInt) && (localApolloGameRankData.mRank == 1) && (str.equals(localApolloGameRankData.mFriendUin))) {
              return true;
            }
            if ((localApolloGameRankData != null) && (!localApolloGameRankData.isInvalid())) {
              localArrayList.add(localApolloGameRankData);
            }
          }
        }
        if (localObject2.size() > 0)
        {
          Iterator localIterator = localObject2.iterator();
          while (localIterator.hasNext())
          {
            localObject3 = (ApolloGameRankData)localIterator.next();
            ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ApolloGameRankData)localObject3);
            this.jdField_c_of_type_JavaUtilList.remove(localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGameViewBinder", 2, new Object[] { "[valid] remove red corner for ", localObject3 });
            }
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "beyond_notice_disappear", 2, 0, new String[] { String.valueOf(((ApolloGameRankData)localObject3).mGameId) });
          }
        }
      }
    }
    return false;
  }
  
  public ApolloGameData b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, "[removeProgress]");
    }
    if (this.e != null) {
      this.e.setVisibility(8);
    }
  }
  
  public void b(List<ApolloGameData> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, "[updateGameList]");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1036))
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_Anpz.notifyDataSetChanged();
    }
    do
    {
      return;
      if ((paramList != null) && (amsn.a("aio.city.game", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == amso.d)) {
        paramList.add(0, a());
      }
    } while ((this.jdField_b_of_type_JavaUtilList == null) || (paramList == null) || (this.jdField_a_of_type_Anpz == null));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Anpz.notifyDataSetChanged();
  }
  
  public void c()
  {
    if ((a()) && (amma.a("apollo_aio_game_guide") == -1))
    {
      amma.a("apollo_aio_game_guide", 1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, "[onDestroy] from notify");
      }
    }
    if (this.jdField_a_of_type_Blhb != null) {}
    try
    {
      this.jdField_a_of_type_Blhb.dismiss();
      this.jdField_a_of_type_Blhb = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameViewBinder", 1, localThrowable, new Object[] { "[onPanelClose] dissmiss window " });
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, "[onPanelOpen]");
    }
    boolean bool = a();
    QQAppInterface localQQAppInterface;
    SessionInfo localSessionInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloPanel != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloPanel.a()) || (bool)))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (!bool) {
        break label170;
      }
    }
    label170:
    for (int i = 0;; i = 1)
    {
      ApolloGameUtil.a(localQQAppInterface, localSessionInfo, i);
      if (amsn.a("aio.panel.rank.time") < System.currentTimeMillis() / 1000L)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 0)) {
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
        }
        amsn.a("aio.panel.rank.time", (int)(System.currentTimeMillis() / 1000L) + 300);
      }
      return;
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpu
 * JD-Core Version:    0.7.0.1
 */