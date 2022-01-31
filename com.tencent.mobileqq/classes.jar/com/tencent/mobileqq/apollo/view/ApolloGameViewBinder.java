package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloGameBtnData;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.apollo.game.ApolloGameConst;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zek;
import zel;

public class ApolloGameViewBinder
  extends ApolloViewBinder
  implements View.OnClickListener
{
  public static long a;
  public static boolean a;
  private int jdField_a_of_type_Int = -1;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ApolloGameData a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private CalloutPopupWindow jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow;
  private zel jdField_a_of_type_Zel;
  int[] jdField_a_of_type_ArrayOfInt = { 1002, 1001, 1000, 1005 };
  private int jdField_b_of_type_Int = -1;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private SessionInfo jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  private List jdField_b_of_type_JavaUtilList;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RedTouch jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch;
  private List jdField_c_of_type_JavaUtilList;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private ImageView e;
  private int g = 1;
  private int h;
  private int i = -1;
  
  public ApolloGameViewBinder(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_d_of_type_Int = 100;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.h = ApolloUtil.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo, paramQQAppInterface);
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
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363138));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363139));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363140));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363141));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363143));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363144));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363142));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363145));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363146));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363147));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363148));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363149));
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363150));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131363151));
      this.e = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363152));
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      this.e.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      paramView = (ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210);
      if (paramView != null) {
        paramView.f();
      }
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
    if (paramApolloGameData.isSetting)
    {
      if (this.jdField_b_of_type_AndroidContentContext != null)
      {
        localObject = ApolloConstant.am;
        if (!TextUtils.isEmpty(paramApolloGameData.toolUrl)) {
          localObject = paramApolloGameData.toolUrl;
        }
        for (;;)
        {
          try
          {
            if ("1".equals(Uri.parse((String)localObject).getQueryParameter("useApolloBrowser")))
            {
              ApolloUtil.a(this.jdField_b_of_type_AndroidContentContext, null, "aio", (String)localObject, null);
              VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_more_game_enter", ApolloUtil.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, new String[0]);
              return;
            }
          }
          catch (Throwable paramApolloGameData)
          {
            QLog.e("ApolloGameViewBinder", 1, paramApolloGameData, new Object[] { "[onGameItemClick]" });
            return;
          }
          paramApolloGameData = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
          VasWebviewUtil.openQQBrowserActivity(this.jdField_b_of_type_AndroidContentContext, (String)localObject, -1L, paramApolloGameData, false, -1);
        }
      }
      QLog.e("ApolloGameViewBinder", 1, "[onGameItemClick] empty context");
    }
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    Object localObject = new CmGameStartChecker.StartCheckParam(paramApolloGameData.gameId, true, "launch", 0L, 0, 0, this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 100);
    ApolloGameUtil.a(this.jdField_b_of_type_AndroidContentContext, (CmGameStartChecker.StartCheckParam)localObject);
    if ((this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramApolloGameData.gameId) != null) && (((SparseArray)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramApolloGameData.gameId)).size() > 0))
    {
      localObject = (SparseArray)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramApolloGameData.gameId);
      if (((SparseArray)localObject).get(2000) != null)
      {
        ((SparseArray)localObject).remove(2000);
        ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramApolloGameData.gameId, 2000);
        if (this.jdField_a_of_type_Zel != null) {
          this.jdField_a_of_type_Zel.notifyDataSetChanged();
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int k = this.h;
      int m = paramApolloGameData.gameId;
      if (j != 0)
      {
        localObject = "1";
        if (paramApolloGameData.type != 2) {
          break label462;
        }
      }
      label462:
      for (paramApolloGameData = "1";; paramApolloGameData = "0")
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_game_banner", k, 0, new String[] { String.valueOf(m), localObject, paramApolloGameData });
        return;
        localObject = "0";
        break;
      }
    }
  }
  
  private void a(ApolloGameData paramApolloGameData, boolean paramBoolean)
  {
    if (paramApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[updateGameItemView] no game info");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updateGameItemView] gameId=", Integer.valueOf(paramApolloGameData.gameId), ", isRunning=", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData = paramApolloGameData;
    Object localObject1;
    int j;
    label94:
    int k;
    label158:
    label193:
    label340:
    label497:
    label505:
    label1020:
    int m;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (this.jdField_b_of_type_JavaUtilList.size() == 1)
      {
        j = 2130838007;
        ((ImageView)localObject1).setImageResource(j);
      }
    }
    else
    {
      localObject1 = paramApolloGameData.actUrl;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updateGameItemView] activityUrl=", localObject1 });
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1126;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setTag(localObject1);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.toolUrl)) {
        break label1146;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.toolUrl);
      if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(this.jdField_b_of_type_AndroidWidgetImageView.getVisibility());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(this.jdField_d_of_type_AndroidWidgetImageView.getVisibility());
      }
      if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(this.jdField_c_of_type_AndroidWidgetImageView.getVisibility());
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.getHomeActionBtn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject1 == null) {
        break label1166;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = 60;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = 60;
      localObject1 = URLDrawable.getDrawable(((ApolloGameBtnData)localObject1).jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      k = 0;
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        break label1385;
      }
      localObject2 = (SparseArray)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.gameId);
      if (localObject2 == null) {
        break label1318;
      }
      localObject1 = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.gameId, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((!b()) || (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
        break label1217;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_b_of_type_AndroidContentContext, this.jdField_c_of_type_AndroidWidgetImageView).a(53).a();
      }
      Object localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(0);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "apolloGameReddot updateGameItemView gameCenterRedDot.isTimeValid():true");
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject1 != null) {
        break label1188;
      }
      j = 0;
      if (localObject1 != null) {
        break label1197;
      }
      k = 0;
      if (localObject1 != null) {
        break label1207;
      }
      localObject1 = Integer.valueOf(0);
      label516:
      VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "reddot_show", j, 0, new String[] { String.valueOf(k), String.valueOf(1), String.valueOf(localObject1) });
      label559:
      localObject1 = (ApolloGameRedDot)((SparseArray)localObject2).get(1001);
      if ((localObject1 == null) || (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0) || (((ApolloGameRedDot)localObject1).mIsShow)) {
        break label1250;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_b_of_type_AndroidContentContext, this.jdField_d_of_type_AndroidWidgetImageView).a(53).a();
      }
      localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(0);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "apolloGameReddot updateGameItemView gameActivityRedDot.isTimeValid():true");
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "reddot_show", ((ApolloGameRedDot)localObject1).mDotId, 0, new String[] { String.valueOf(((ApolloGameRedDot)localObject1).mGameId), String.valueOf(1), String.valueOf(((ApolloGameRedDot)localObject1).mActId) });
      j = 1;
      label729:
      localObject1 = (ApolloGameRedDot)((SparseArray)localObject2).get(1002);
      if ((localObject1 == null) || (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) || (((ApolloGameRedDot)localObject1).mIsShow)) {
        break label1285;
      }
      if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
        this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_b_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetImageView).a(53).a();
      }
      localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject2);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "reddot_show", ((ApolloGameRedDot)localObject1).mDotId, 0, new String[] { String.valueOf(((ApolloGameRedDot)localObject1).mGameId), String.valueOf(1), String.valueOf(((ApolloGameRedDot)localObject1).mActId) });
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "apolloGameReddot updateGameItemView mToolRedtouch.isTimeValid():true");
      }
      label897:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updateGameItemView] bigCoverUrl=", this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.bigCoverUrl, ", bigCoverBgColor=", this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.bigCoverBgColor });
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.bigCoverUrl)) {
        break label1452;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(0);
      localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.bigCoverUrl, (URLDrawable.URLDrawableOptions)localObject1);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.bigCoverBgColor)) {
        break label1463;
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.bigCoverBgColor));
      label1050:
      if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label1472;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      k = this.h;
      m = paramApolloGameData.gameId;
      if (j == 0) {
        break label1474;
      }
    }
    label1166:
    label1188:
    label1197:
    label1207:
    label1217:
    label1474:
    for (paramApolloGameData = "1";; paramApolloGameData = "0")
    {
      VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "activity_show", k, 0, new String[] { String.valueOf(m), paramApolloGameData });
      return;
      j = 2130838075;
      break label94;
      label1126:
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setTag(null);
      break label158;
      label1146:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(null);
      break label193;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838051);
      QLog.e("ApolloGameViewBinder", 1, "[updateGameItemView] not found drawable ");
      break label340;
      j = ((ApolloGameRedDot)localObject1).mDotId;
      break label497;
      k = ((ApolloGameRedDot)localObject1).mGameId;
      break label505;
      localObject1 = ((ApolloGameRedDot)localObject1).mActId;
      break label516;
      if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      if (!QLog.isColorLevel()) {
        break label559;
      }
      QLog.d("", 2, "apolloGameReddot updateGameItemView gameActivityRedDot.is null");
      break label559;
      label1250:
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "apolloGameReddot updateGameItemView gameActivityRedDot.is null");
      }
      j = 0;
      break label729;
      if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      if (!QLog.isColorLevel()) {
        break label897;
      }
      QLog.d("", 2, "apolloGameReddot updateGameItemView gameToolRedDot.is null");
      break label897;
      if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      j = k;
      if (!QLog.isColorLevel()) {
        break label897;
      }
      QLog.d("", 2, "apolloGameReddot updateGameItemView clear all reddot gameIdReddotMap is null");
      j = k;
      break label897;
      label1385:
      if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      j = k;
      if (!QLog.isColorLevel()) {
        break label897;
      }
      QLog.d("", 2, "apolloGameReddot updateGameItemView clear all reddot mRedDotSparseMap is null");
      j = k;
      break label897;
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
      break label1020;
      this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(0);
      break label1050;
      break;
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      SparseArray localSparseArray = (SparseArray)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.gameId);
      if (localSparseArray != null)
      {
        int j = 0;
        while (j < 4)
        {
          ApolloGameRedDot localApolloGameRedDot = (ApolloGameRedDot)localSparseArray.get(this.jdField_a_of_type_ArrayOfInt[j]);
          if ((localApolloGameRedDot != null) && (((localApolloGameRedDot.mDotId == 1001) && (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0)) || ((localApolloGameRedDot.mDotId == 1002) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0)) || (((localApolloGameRedDot.mDotId == 1000) || (localApolloGameRedDot.mDotId == 1005)) && (!localApolloGameRedDot.mIsShow)))) {
            return true;
          }
          j += 1;
        }
        return false;
      }
      return false;
    }
    return false;
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
    if (this.jdField_b_of_type_AndroidContentContext == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[createPanelView] context null");
      localObject1 = null;
    }
    Object localObject2;
    TextView localTextView;
    do
    {
      return localObject1;
      switch (this.jdField_c_of_type_Int)
      {
      default: 
        localObject1 = (ViewGroup)LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2130968677, null);
        localObject2 = (XListView)((ViewGroup)localObject1).findViewById(2131363138);
        return localObject1;
      }
      localObject2 = (ViewGroup)LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2130968681, null);
      localTextView = (TextView)((ViewGroup)localObject2).findViewById(2131363185);
      if (ApolloGameManager.a())
      {
        localTextView.setOnClickListener(null);
        localTextView.setText(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131438257));
        return localObject2;
      }
      localObject1 = localObject2;
    } while (!NetworkUtil.g(this.jdField_b_of_type_AndroidContentContext));
    localTextView.setText("点击刷新");
    localTextView.setOnClickListener(new zek(this));
    return localObject2;
  }
  
  public ApolloGameData a()
  {
    ApolloGameData localApolloGameData = new ApolloGameData();
    localApolloGameData.gameId = 2147483647;
    localApolloGameData.isShow = 1;
    localApolloGameData.name = ApolloGameConfig.a("aio.enter.name");
    localApolloGameData.listCoverUrl = ApolloGameConfig.a("aio.enter.bg");
    localApolloGameData.isSetting = true;
    localApolloGameData.toolUrl = ApolloGameConfig.a("aio.enter");
    return localApolloGameData;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if (this.jdField_a_of_type_Zel != null) {
      this.jdField_a_of_type_Zel.a();
    }
    if ((a()) && (ApolloGameManager.a("apollo_aio_game_guide") == -1))
    {
      ApolloGameManager.a("apollo_aio_game_guide", 1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, "[onDestroy] from destory");
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameViewBinder", 1, localThrowable, new Object[] { "[onPanelClose] dissmiss window " });
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[setJumpGameId] jumpGameId=", Integer.valueOf(paramInt) });
    }
    this.i = paramInt;
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
      } while (this.jdField_c_of_type_Int == 8);
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
    if (this.jdField_b_of_type_JavaUtilList.size() > 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, "[updatePanel] prepare list data");
      }
      if (this.jdField_a_of_type_Zel == null) {
        this.jdField_a_of_type_Zel = new zel(this.jdField_b_of_type_AndroidContentContext, this);
      }
      this.jdField_a_of_type_Zel.a(this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Zel);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updatePanel] jumpGameInfo=", null });
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updatePanel] running game=", null });
    }
    if (0 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, "[updatePanel] show jump game");
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      if (0 != 0)
      {
        throw new NullPointerException();
        a(null, false);
        if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
          break label629;
        }
        paramView = this.jdField_a_of_type_AndroidUtilSparseArray;
        throw new NullPointerException();
      }
    }
    label629:
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramInt = this.h;
      paramView = new String[1];
      throw new NullPointerException();
      break;
      if (0 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameViewBinder", 2, "[updatePanel] game running");
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        a(null, true);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameViewBinder", 2, "[updatePanel] game item showing");
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        a(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData, false);
        return;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() > 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameViewBinder", 2, "[updatePanel] show game list");
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, "[updatePanel] just one game, show it");
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      a((ApolloGameData)this.jdField_b_of_type_JavaUtilList.get(0), false);
      return;
    }
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[setGameList] list=", paramList });
    }
    if ((paramList != null) && (ApolloGameConfig.a("aio.city.game", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == ApolloGameConst.jdField_d_of_type_Int)) {
      paramList.add(0, a());
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidUtilSparseArray = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      paramList = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
      int j = 0;
      while ((this.jdField_b_of_type_JavaUtilList != null) && (j < this.jdField_b_of_type_JavaUtilList.size()))
      {
        paramList = (ApolloGameData)this.jdField_b_of_type_JavaUtilList.get(j);
        if (paramList != null)
        {
          SparseArray localSparseArray = (SparseArray)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramList.gameId);
          if ((localSparseArray != null) && (localSparseArray.size() > 0))
          {
            if (TextUtils.isEmpty(paramList.actUrl)) {
              localSparseArray.remove(1001);
            }
            if (TextUtils.isEmpty(paramList.toolUrl)) {
              localSparseArray.remove(1002);
            }
          }
        }
        j += 1;
      }
    }
    this.jdField_c_of_type_JavaUtilList = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).g(6);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a() == 7);
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ??? = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
      if (TextUtils.isEmpty(a())) {
        return false;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        this.jdField_c_of_type_JavaUtilList = ((ApolloDaoManager)???).a(ApolloGameUtil.a(), this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  public void b(int paramInt)
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
  
  public void c()
  {
    if ((a()) && (ApolloGameManager.a("apollo_aio_game_guide") == -1))
    {
      ApolloGameManager.a("apollo_aio_game_guide", 1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, "[onDestroy] from notify");
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
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
    QQAppInterface localQQAppInterface;
    SessionInfo localSessionInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a()))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localSessionInfo = this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (!a()) {
        break label162;
      }
    }
    label162:
    for (int j = 0;; j = 1)
    {
      ApolloGameUtil.a(localQQAppInterface, localSessionInfo, j);
      if (ApolloGameConfig.a("aio.panel.rank.time") < System.currentTimeMillis() / 1000L)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)) {
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ApolloGameConfig.a("aio.panel.rank.time", (int)(System.currentTimeMillis() / 1000L) + 300);
      }
      return;
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder
 * JD-Core Version:    0.7.0.1
 */