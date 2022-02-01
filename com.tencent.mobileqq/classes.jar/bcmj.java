import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class bcmj
  implements View.OnClickListener
{
  bcmj(bcme parambcme) {}
  
  public void onClick(View paramView)
  {
    localObject8 = null;
    long l2 = 0L;
    Context localContext = paramView.getContext();
    Object localObject1 = paramView.getTag(2131377864);
    if ((localObject1 != null) && ((localObject1 instanceof bcml)))
    {
      localObject6 = (bcml)localObject1;
      if ((!(this.a.a instanceof StructMsgForGeneralShare)) || (TextUtils.isEmpty(((StructMsgForGeneralShare)this.a.a).mMsgActionData)) || (!((StructMsgForGeneralShare)this.a.a).mMsgActionData.startsWith("mqqapi://qsubscribe"))) {
        break label163;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new Intent(localContext, JumpActivity.class);
        ((Intent)localObject1).setData(Uri.parse(((StructMsgForGeneralShare)this.a.a).mMsgActionData));
        ((Intent)localObject1).putExtra("from", "from_aio");
        localContext.startActivity((Intent)localObject1);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        continue;
      }
      label163:
      Object localObject2;
      if (this.a.v == 4)
      {
        if ("3".equals(this.a.ax))
        {
          bcme.a(this.a);
          localObject2 = (ofx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(88);
          if (localObject2 != null) {
            ((ofx)localObject2).a(this.a, (Activity)localContext);
          }
        }
        else
        {
          Object localObject4 = "";
          localObject2 = localObject4;
          if (this.a.a != null)
          {
            localObject2 = localObject4;
            if (this.a.a.message != null) {
              localObject2 = this.a.a.message.getExtInfoFromExtStr("public_account_msg_id");
            }
          }
          long l1 = l2;
          if (((bcml)localObject6).a.getDrawable() != null)
          {
            l1 = l2;
            if ((((bcml)localObject6).a.getDrawable() instanceof URLDrawable))
            {
              localObject4 = (URLDrawable)((bcml)localObject6).a.getDrawable();
              l1 = l2;
              if (((URLDrawable)localObject4).getStatus() == 1)
              {
                l1 = l2;
                if ((((URLDrawable)localObject4).getCurrDrawable() instanceof QQLiveDrawable)) {
                  l1 = ((QQLiveDrawable)((URLDrawable)localObject4).getCurrDrawable()).getCurrentPosition();
                }
              }
            }
          }
          localObject4 = (String)paramView.getTag(2131377871);
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            String str = bjnd.a(bjnd.a((String)localObject4, "progress", String.valueOf(l1)), "msgId", (String)localObject2);
            Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            for (;;)
            {
              for (;;)
              {
                Object localObject5;
                Object localObject3;
                try
                {
                  localObject2 = this.a.a.message.getExtInfoFromExtStr("gdt_view_id");
                  try
                  {
                    localObject4 = this.a.a.message.getExtInfoFromExtStr("gdt_msgImp");
                    if (TextUtils.isEmpty((CharSequence)localObject4))
                    {
                      localObject6 = new JSONObject();
                      localObject4 = ((JSONObject)localObject6).optString("ad_id");
                    }
                  }
                  catch (Exception localException3)
                  {
                    StringBuilder localStringBuilder2;
                    StringBuilder localStringBuilder1 = null;
                    localObject6 = localObject8;
                    localObject5 = localObject2;
                    localObject2 = localStringBuilder1;
                  }
                }
                catch (Exception localException2)
                {
                  boolean bool;
                  int i;
                  localObject3 = null;
                  localObject5 = null;
                  localObject6 = localObject8;
                  continue;
                }
                Object localObject7;
                try
                {
                  localObject6 = ((JSONObject)localObject6).optString("key");
                }
                catch (Exception localException4)
                {
                  localObject8 = null;
                  localObject7 = localObject5;
                  localObject5 = localObject3;
                  localObject3 = localObject8;
                  continue;
                }
                try
                {
                  bcme.a(this.a);
                  Long.parseLong((String)localObject4);
                  localObject8 = localObject6;
                  localObject6 = localObject4;
                  localObject4 = localObject8;
                  localObject8 = localObject2;
                  if (localObject2 != null) {
                    localObject8 = ((String)localObject2).replace("\"", "").replace("\n", "");
                  }
                  localStringBuilder1 = new StringBuilder();
                  localStringBuilder2 = localStringBuilder1.append(str);
                  if (!str.contains("?")) {
                    continue;
                  }
                  localObject2 = "&view_id=";
                  localStringBuilder2.append((String)localObject2).append(String.valueOf(localObject8)).append("&ad_id=").append(String.valueOf(localObject6)).append("&trace_id=").append(String.valueOf(localObject4));
                  localIntent.putExtra("url", localStringBuilder1.toString());
                  localIntent.putExtra("big_brother_source_key", ugf.b(this.a.ab));
                  localContext.startActivity(localIntent);
                }
                catch (Exception localException5)
                {
                  Object localObject9 = localObject5;
                  localObject5 = localObject3;
                  localObject3 = localObject7;
                  localObject7 = localObject9;
                }
              }
              localObject6 = new JSONObject((String)localObject4);
              continue;
              localObject8 = localObject2;
              localObject2 = localObject5;
              localObject5 = localObject8;
              continue;
              localObject2 = "?view_id=";
            }
          }
        }
      }
      else
      {
        if (pay.a(this.a.a))
        {
          bool = bcme.a(localContext, this.a.a.uinType);
          localObject2 = new StringBuilder().append(this.a.a.mMsgUrl).append("&sourceAutoPlay=");
          if (bool) {}
          for (i = 1;; i = 0)
          {
            pay.d(localContext, i);
            break;
          }
        }
        localObject2 = bcgr.a();
        if (!((bcgr)localObject2).a())
        {
          if ((this.a.a instanceof StructMsgForGeneralShare))
          {
            localObject2 = (StructMsgForGeneralShare)this.a.a;
            this.a.a(localContext, (StructMsgForGeneralShare)localObject2, 0L);
          }
        }
        else if (((bcgr)localObject2).a(localContext, 3, this.a.a.uinType))
        {
          if ((this.a.a instanceof StructMsgForGeneralShare))
          {
            localObject2 = (StructMsgForGeneralShare)this.a.a;
            this.a.a(localContext, (StructMsgForGeneralShare)localObject2, 0L);
          }
        }
        else if (!HttpUtil.isConnect(localContext)) {
          QQToast.a(localContext, 2131692035, 0).a();
        } else {
          this.a.a(localContext, (StructMsgForGeneralShare)this.a.a, 0L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmj
 * JD-Core Version:    0.7.0.1
 */