package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class BaseChatItemLayout$2
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject1 = (ChatMessage)paramCompoundButton.getTag();
    if (localObject1 == null) {}
    label507:
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if ((localObject1 instanceof MessageForPtt))
      {
        localObject2 = MediaPlayerManager.a(BaseActivity.sTopActivity.app).a();
        if ((localObject2 == localObject1) || (((localObject2 instanceof MessageForPtt)) && (((ChatMessage)localObject2).uniseq == ((ChatMessage)localObject1).uniseq))) {
          MediaPlayerManager.a(BaseActivity.sTopActivity.app).c(false);
        }
      }
      Object localObject2 = AIOLongShotHelper.a();
      if ((localObject2 != null) && (((AIOLongShotHelper)localObject2).a()))
      {
        if ((paramBoolean != ((AIOLongShotHelper)localObject2).a((ChatMessage)localObject1)) && (BaseChatItemLayout.a != null)) {
          BaseChatItemLayout.a.a((ChatMessage)localObject1, paramCompoundButton, paramBoolean);
        }
      }
      else if (paramBoolean != MultiMsgManager.a().a((ChatMessage)localObject1))
      {
        if (!paramBoolean) {
          MultiMsgManager.a().a((ChatMessage)localObject1, paramBoolean);
        }
        for (;;)
        {
          if (BaseChatItemLayout.a == null) {
            break label507;
          }
          BaseChatItemLayout.a.a((ChatMessage)localObject1, paramCompoundButton, paramBoolean);
          break;
          if ((localObject1 instanceof MessageForFile))
          {
            localObject2 = FileManagerUtil.a(BaseActivity.sTopActivity.app, (MessageForFile)localObject1);
            if ((((FileManagerEntity)localObject2).getCloudType() == 1) && (((FileManagerEntity)localObject2).status == 2))
            {
              localObject1 = paramCompoundButton.getContext().getString(2131692618);
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              break;
            }
          }
          if ((localObject1 instanceof MessageForTroopFile))
          {
            localObject2 = (MessageForTroopFile)localObject1;
            localObject2 = TroopFileUtils.a(BaseActivity.sTopActivity.app, (MessageForTroopFile)localObject2);
            if ((localObject2 != null) && ((((TroopFileStatusInfo)localObject2).b == 0) || (((TroopFileStatusInfo)localObject2).b == 1) || (((TroopFileStatusInfo)localObject2).b == 2) || (((TroopFileStatusInfo)localObject2).b == 3) || (((TroopFileStatusInfo)localObject2).b == 4)))
            {
              localObject1 = paramCompoundButton.getContext().getString(2131692618);
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              break;
            }
          }
          int i = MultiMsgManager.a().a();
          if (MultiMsgManager.a().a((ChatMessage)localObject1, i))
          {
            if (MultiMsgManager.a().a == 7) {}
            for (localObject1 = paramCompoundButton.getContext().getString(2131698463, new Object[] { Integer.valueOf(i) });; localObject1 = paramCompoundButton.getContext().getString(2131698462, new Object[] { Integer.valueOf(i) }))
            {
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              break;
            }
          }
          MultiMsgManager.a().a((ChatMessage)localObject1, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout.2
 * JD-Core Version:    0.7.0.1
 */