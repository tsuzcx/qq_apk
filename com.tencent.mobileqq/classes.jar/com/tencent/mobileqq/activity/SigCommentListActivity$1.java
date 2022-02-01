package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.adapter.SigCommentSessionListAdapter;
import com.tencent.mobileqq.app.SignatureManager.SigComments;
import com.tencent.mobileqq.app.SignatureObserver;
import java.util.List;

class SigCommentListActivity$1
  extends SignatureObserver
{
  SigCommentListActivity$1(SigCommentListActivity paramSigCommentListActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (this.a.isResume())
    {
      this.a.stopTitleProgress();
      if (paramBoolean)
      {
        if ((paramObject instanceof Bundle))
        {
          paramObject = (SignatureManager.SigComments)((Bundle)paramObject).getSerializable("data");
          paramBoolean = paramObject.isOver;
          paramObject = paramObject.mlist;
          List localList = this.a.a.a();
          if (paramObject.size() > 0)
          {
            if (localList != null)
            {
              localList.addAll(localList.size(), paramObject);
              this.a.a.a(localList, paramBoolean);
            }
            else
            {
              this.a.a.a(paramObject, paramBoolean);
            }
            this.a.a.notifyDataSetChanged();
            return;
          }
          if ((localList != null) && (localList.size() > 0)) {
            this.a.a.a(localList, paramBoolean);
          } else {
            SigCommentListActivity.a(this.a, 3);
          }
          this.a.a.notifyDataSetChanged();
        }
      }
      else
      {
        paramObject = this.a.a.a();
        if ((paramObject != null) && (paramObject.size() > 0)) {
          return;
        }
        SigCommentListActivity.a(this.a, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SigCommentListActivity.1
 * JD-Core Version:    0.7.0.1
 */