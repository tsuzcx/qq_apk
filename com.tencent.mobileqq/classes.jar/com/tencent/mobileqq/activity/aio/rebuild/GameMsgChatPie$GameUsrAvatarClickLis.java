package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msgInfo.GameUserInfo;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class GameMsgChatPie$GameUsrAvatarClickLis
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  WeakReference<Context> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public GameMsgChatPie$GameUsrAvatarClickLis(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = false;
    this.b = paramBoolean;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
  }
  
  private void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null) {
      return;
    }
    localObject = ((IGameMsgManagerService)((QQAppInterface)localObject).getRuntimeService(IGameMsgManagerService.class, "")).findGameUserInfo(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GameUsrAvatarClickLis, usrInfo is null, roleId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("GameMsgChatPie", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (TextUtils.isEmpty(((GameUserInfo)localObject).mFaceUrl))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GameUsrAvatarClickLis, faceurl is null, roleId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("GameMsgChatPie", 1, ((StringBuilder)localObject).toString());
      return;
    }
    paramString = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130840321);
    paramString.mFailedDrawable = localDrawable;
    paramString.mLoadingDrawable = localDrawable;
    paramString.mRequestWidth = AIOUtils.b(60.0F, BaseApplicationImpl.getContext().getResources());
    paramString.mRequestHeight = AIOUtils.b(60.0F, BaseApplicationImpl.getContext().getResources());
    URLDrawable.removeMemoryCacheByUrl(((GameUserInfo)localObject).mFaceUrl, paramString);
    boolean bool = FileUtils.deleteFile(AbsDownloader.getFilePath(((GameUserInfo)localObject).mFaceUrl));
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("GameUsrAvatarClickLis del ret:");
      paramString.append(bool);
      QLog.d("GameMsgChatPie", 2, paramString.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L)
    {
      QLog.w("GameMsgChatPie", 1, "GameUsrAvatarClickLis, click too fast!!!");
    }
    else
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      ThreadManager.getSubThreadHandler().post(new GameMsgChatPie.GameUsrAvatarClickLis.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis
 * JD-Core Version:    0.7.0.1
 */