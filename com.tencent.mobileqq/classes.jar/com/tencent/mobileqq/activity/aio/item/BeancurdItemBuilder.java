package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.beancurd.BeancurdView;
import com.tencent.mobileqq.beancurd.BeancurdView.OnClickBeancurdListener;
import com.tencent.mobileqq.data.MessageForBeancurd;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class BeancurdItemBuilder
  extends AbstractChatItemBuilder
  implements BeancurdView.OnClickBeancurdListener
{
  public BeancurdItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private int a(long paramLong)
  {
    int j = (int)paramLong;
    int i = 1;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 6)
          {
            switch (j)
            {
            default: 
              return 0;
            case 13: 
              return 2;
            case 12: 
              i = 10;
            case 11: 
              return i;
            case 10: 
              return 6;
            case 9: 
              return 5;
            }
            return 9;
          }
          return 8;
        }
        return 7;
      }
      return 3;
    }
    return 4;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForBeancurd)paramMessageRecord;
    paramOnLongClickAndTouchListener = (BeancurdItemBuilder.BeancurdViewHolder)paramViewHolder;
    if (paramView == null) {
      paramOnLongClickAndTouchListener.e = BeancurdView.a(this.c, paramView, paramLinearLayout.getBeancurdStyle());
    }
    if (paramOnLongClickAndTouchListener.e != null)
    {
      paramOnLongClickAndTouchListener.e.a(this);
      paramViewHolder = paramOnLongClickAndTouchListener.e.a(paramLinearLayout);
      paramView = paramViewHolder;
      if (!paramOnLongClickAndTouchListener.d)
      {
        paramOnLongClickAndTouchListener.d = true;
        int i = a(paramLinearLayout.getBusiid());
        paramView = paramViewHolder;
        if (i != 0)
        {
          ReportController.b(null, "dc00898", "", paramMessageRecord.frienduin, "0X800BBAF", "0X800BBAF", 0, i, "", "", paramLinearLayout.getBusi_uuid(), "");
          paramView = paramViewHolder;
        }
      }
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new BeancurdItemBuilder.BeancurdViewHolder(this);
  }
  
  public void a(MessageForBeancurd paramMessageForBeancurd)
  {
    long l = paramMessageForBeancurd.getBusiid();
    if (l == 13L)
    {
      AnonymousViewHelper.jumpToQuestionListAndAnswer((BaseActivity)this.c, paramMessageForBeancurd.frienduin, 9);
    }
    else
    {
      Object localObject;
      if (l == 1L)
      {
        localObject = new Intent(this.c, PublicFragmentActivity.class);
        ((Intent)localObject).putExtra("key_uin", this.d.b);
        ((Intent)localObject).putExtra("key_uin_name", this.d.e);
        ((Intent)localObject).putExtra("key_open_via", "history-liaotian");
        PublicFragmentActivity.Launcher.a(this.c, (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
      }
      else if (l == 3L)
      {
        localObject = new AllInOne(this.d.b, 1);
        Intent localIntent = new Intent(this.c, PersonalityLabelGalleryActivity.class);
        localIntent.putExtra("personality_label_allinone", (Parcelable)localObject);
        localIntent.putExtra("fromType", 2);
        localIntent.putExtra("uin", this.d.b);
        localIntent.putExtra("nickname", this.d.e);
        localIntent.addFlags(536870912);
        if (!(this.c instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        this.c.startActivity(localIntent);
      }
    }
    int i = a(l);
    if (i != 0) {
      ReportController.b(null, "dc00898", "", paramMessageForBeancurd.frienduin, "0X800BBB0", "0X800BBB0", 0, i, "", "", paramMessageForBeancurd.getBusi_uuid(), "");
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BeancurdItemBuilder
 * JD-Core Version:    0.7.0.1
 */