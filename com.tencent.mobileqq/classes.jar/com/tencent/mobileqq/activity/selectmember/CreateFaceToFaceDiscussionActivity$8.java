package com.tencent.mobileqq.activity.selectmember;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearFieldDiscussObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.BusiRespHead;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

class CreateFaceToFaceDiscussionActivity$8
  extends NearFieldDiscussObserver
{
  CreateFaceToFaceDiscussionActivity$8(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int j = ((Integer)paramObject[0]).intValue();
    int i;
    if (paramObject.length == 3) {
      i = ((Integer)paramObject[2]).intValue();
    } else {
      i = -1;
    }
    if (this.a.mQQProgressDialog != null)
    {
      this.a.mQQProgressDialog.dismiss();
      this.a.mQQProgressDialog = null;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetNearFieldDiscussInfo ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" mSessionId=");
      ((StringBuilder)localObject1).append(this.a.mSessionId);
      ((StringBuilder)localObject1).append(" sessionId=");
      ((StringBuilder)localObject1).append(j);
      QLog.d("CreateFaceToFaceDiscussionActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      paramObject = (String)paramObject[1];
      if (j == this.a.mSessionId)
      {
        if ((i == 0) && (DiscussionInfo.isValidDisUin(paramObject)))
        {
          this.a.finish();
          localObject1 = ContactUtils.a(this.a.app, this.a.getActivity().getApplicationContext(), paramObject);
          localObject2 = AIOUtils.a(new Intent(this.a.getActivity(), SplashActivity.class), null);
          ((Intent)localObject2).putExtra("uin", paramObject);
          ((Intent)localObject2).putExtra("uintype", 3000);
          ((Intent)localObject2).putExtra("uinname", (String)localObject1);
          ((Intent)localObject2).putExtra("isBack2Root", true);
          this.a.startActivity((Intent)localObject2);
          return;
        }
        if ((i != 2) && (i != 1))
        {
          paramObject = this.a;
          CreateFaceToFaceDiscussionActivity.access$100(paramObject, 1, paramObject.getString(2131692182));
          return;
        }
        this.a.finish();
        localObject1 = AIOUtils.a(new Intent(this.a.getActivity(), SplashActivity.class), null);
        ((Intent)localObject1).putExtra("uin", paramObject);
        ((Intent)localObject1).putExtra("uintype", 1);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(ContactUtils.e(this.a.app, this.a.app.getCurrentAccountUin()));
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131702789));
        ((Intent)localObject1).putExtra("uinname", ((StringBuilder)localObject2).toString());
        ((Intent)localObject1).putExtra("isBack2Root", true);
        this.a.startActivity((Intent)localObject1);
        ReportController.b(this.a.app, "dc00899", "Grp_create", "", "f2f", "cre_suc", 0, 0, paramObject, "", "", "");
      }
    }
    else if (j == this.a.mSessionId)
    {
      paramObject = this.a;
      CreateFaceToFaceDiscussionActivity.access$200(paramObject, 1, paramObject.getString(2131692182));
    }
  }
  
  protected void a(boolean paramBoolean, List<nearfield_discuss.UserProfile> paramList, int paramInt1, int paramInt2, nearfield_discuss.BusiRespHead paramBusiRespHead, int paramInt3, int paramInt4, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NearFieldDiscussObserver isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ; interval = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if (paramInt1 > 0) {
        this.a.mInterval = (paramInt1 * 1000);
      }
      if ((paramBusiRespHead != null) && (paramBusiRespHead.int32_reply_code.get() != 0))
      {
        if (!this.a.isEnteredHall)
        {
          paramList = paramBusiRespHead.str_result.get();
          QQToast.a(this.a.mContext, paramList, 0).a();
          ((Animatable)this.a.mProgressDrawable).stop();
          this.a.progress.setVisibility(4);
          if (this.a.mHandler.hasMessages(1)) {
            this.a.mHandler.removeMessages(1);
          }
          this.a.mHandler.sendEmptyMessageDelayed(1, 600L);
        }
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("head.int32_reply_code = ");
          paramList.append(paramBusiRespHead.int32_reply_code.get());
          QLog.i("CreateFaceToFaceDiscussionActivity", 2, paramList.toString());
        }
        return;
      }
      paramBusiRespHead = "";
      localObject = paramBusiRespHead;
      if (paramList != null)
      {
        localObject = paramBusiRespHead;
        if (paramLong != 0L)
        {
          localObject = paramBusiRespHead;
          if (paramInt4 != 0)
          {
            Iterator localIterator = paramList.iterator();
            for (;;)
            {
              localObject = paramBusiRespHead;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject = (nearfield_discuss.UserProfile)localIterator.next();
              if (((nearfield_discuss.UserProfile)localObject).uint64_uin.get() == paramLong) {
                paramBusiRespHead = ((nearfield_discuss.UserProfile)localObject).str_nick.get();
              }
            }
          }
        }
      }
      if (paramInt4 != 0)
      {
        if (paramInt4 != 1)
        {
          if (paramInt4 == 2)
          {
            paramBusiRespHead = this.a;
            paramBusiRespHead.isTroop = true;
            paramBusiRespHead.mCreateTroopBtn.setVisibility(0);
            this.a.mEnterWording.setVisibility(0);
            this.a.mEnterWording.setText(this.a.getString(2131718699, new Object[] { localObject }));
            this.a.mCreateTroopBtn.setText(this.a.getString(2131718697));
            this.a.mCreateTroopBtn.setTextColor(-1);
            this.a.mCreateTroopBtn.setContentDescription(this.a.getString(2131718697));
            this.a.mCreateTroopBtn.setBackgroundResource(2130839280);
          }
        }
        else
        {
          paramBusiRespHead = this.a;
          paramBusiRespHead.isTroop = false;
          paramBusiRespHead.mCreateTroopBtn.setVisibility(0);
          this.a.mEnterWording.setVisibility(0);
          this.a.mEnterWording.setText(this.a.getString(2131718700, new Object[] { localObject }));
          this.a.mCreateTroopBtn.setText(this.a.getString(2131718696));
          this.a.mCreateTroopBtn.setTextColor(-1);
          this.a.mCreateTroopBtn.setContentDescription(this.a.getString(2131718696));
          this.a.mCreateTroopBtn.setBackgroundResource(2130839280);
        }
      }
      else
      {
        CreateFaceToFaceDiscussionActivity.access$300(this.a).setText(this.a.getString(2131689682));
        CreateFaceToFaceDiscussionActivity.access$300(this.a).setContentDescription(this.a.getString(2131689682));
        this.a.mTextviewTip.setText(this.a.getString(2131718694));
        this.a.mTextviewTip.setContentDescription(this.a.getString(2131718694));
        this.a.mEnterTextviewTip.setText(this.a.getString(2131718695));
        this.a.mEnterTextviewTip.setContentDescription(this.a.getString(2131718695));
        this.a.mCreateTroopBtn.setTextColor(this.a.getResources().getColor(2131167089));
        this.a.mCreateTroopBtn.setBackgroundResource(2130839280);
        this.a.mCreateTroopBtn.setText(HardCodeUtil.a(2131702788));
        this.a.mCreateTroopBtn.setContentDescription(HardCodeUtil.a(2131702788));
        this.a.mEnterWording.setVisibility(0);
        this.a.mEnterWording.setText(this.a.getString(2131718698));
      }
      if (this.a.mMemberList == null) {
        this.a.mMemberList = new ArrayList();
      } else {
        this.a.mMemberList.clear();
      }
      this.a.mMemberList.add(this.a.mSelf);
      if (paramList != null) {
        this.a.mMemberList.addAll(paramList);
      }
      if ((paramList == null) && (QLog.isColorLevel())) {
        QLog.i("CreateFaceToFaceDiscussionActivity", 2, "usrList == null");
      }
      if (this.a.mGridViewAdapter != null)
      {
        this.a.mGridViewAdapter.notifyDataSetChanged();
        this.a.mGridview.setVisibility(0);
      }
      if (this.a.isFirstEnterHall)
      {
        paramList = this.a;
        paramList.isFirstEnterHall = false;
        CreateFaceToFaceDiscussionActivity.access$400(paramList);
        paramList = this.a.mHandler.obtainMessage(0);
        this.a.mHandler.sendMessageDelayed(paramList, this.a.mInterval);
      }
    }
    else if (!this.a.isEnteredHall)
    {
      QQToast.a(this.a.mContext, HardCodeUtil.a(2131702786), 1).a();
      if (this.a.mHandler.hasMessages(1)) {
        this.a.mHandler.removeMessages(1);
      }
      this.a.mHandler.sendEmptyMessageDelayed(1, 600L);
    }
    ((Animatable)this.a.mProgressDrawable).stop();
    this.a.progress.setBackgroundDrawable(null);
    this.a.progress.setVisibility(8);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("on push | isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (((Integer)((Object[])(Object[])paramObject)[0]).intValue() == this.a.mSessionId) && (this.a.isResume()))
    {
      if (this.a.mHandler.hasMessages(0)) {
        this.a.mHandler.removeMessages(0);
      }
      this.a.mHandler.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.8
 * JD-Core Version:    0.7.0.1
 */