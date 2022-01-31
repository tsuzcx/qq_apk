import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
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
import org.json.JSONObject;

class azvr
  implements View.OnClickListener
{
  azvr(azvm paramazvm) {}
  
  public void onClick(View paramView)
  {
    long l2 = 0L;
    localObject5 = null;
    Context localContext = paramView.getContext();
    Object localObject1 = paramView.getTag(2131377079);
    if ((localObject1 != null) && ((localObject1 instanceof azvt)))
    {
      localObject7 = (azvt)localObject1;
      if ((!(this.a.a instanceof StructMsgForGeneralShare)) || (TextUtils.isEmpty(((StructMsgForGeneralShare)this.a.a).mMsgActionData)) || (!((StructMsgForGeneralShare)this.a.a).mMsgActionData.startsWith("mqqapi://qsubscribe"))) {
        break label148;
      }
    }
    label148:
    do
    {
      do
      {
        long l1;
        do
        {
          try
          {
            paramView = new Intent(localContext, JumpActivity.class);
            paramView.setData(Uri.parse(((StructMsgForGeneralShare)this.a.a).mMsgActionData));
            paramView.putExtra("from", "from_aio");
            localContext.startActivity(paramView);
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          if (this.a.r != 4) {
            break;
          }
          localObject3 = "";
          localObject1 = localObject3;
          if (this.a.a != null)
          {
            localObject1 = localObject3;
            if (this.a.a.message != null) {
              localObject1 = this.a.a.message.getExtInfoFromExtStr("public_account_msg_id");
            }
          }
          l1 = l2;
          if (((azvt)localObject7).a.getDrawable() != null)
          {
            l1 = l2;
            if ((((azvt)localObject7).a.getDrawable() instanceof URLDrawable))
            {
              localObject3 = (URLDrawable)((azvt)localObject7).a.getDrawable();
              l1 = l2;
              if (((URLDrawable)localObject3).getStatus() == 1)
              {
                l1 = l2;
                if ((((URLDrawable)localObject3).getCurrDrawable() instanceof QQLiveDrawable)) {
                  l1 = ((QQLiveDrawable)((URLDrawable)localObject3).getCurrDrawable()).getCurrentPosition();
                }
              }
            }
          }
          paramView = (String)paramView.getTag(2131377085);
        } while (TextUtils.isEmpty(paramView));
        String str = bhos.a(bhos.a(paramView, "progress", String.valueOf(l1)), "msgId", (String)localObject1);
        Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        for (;;)
        {
          for (;;)
          {
            Object localObject2;
            try
            {
              paramView = this.a.a.message.getExtInfoFromExtStr("gdt_view_id");
              try
              {
                localObject1 = this.a.a.message.getExtInfoFromExtStr("gdt_msgImp");
                if (TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject3 = new JSONObject();
                  localObject1 = ((JSONObject)localObject3).optString("ad_id");
                }
              }
              catch (Exception localException1)
              {
                localObject7 = null;
                localObject3 = localObject5;
                localObject2 = paramView;
                paramView = (View)localObject7;
              }
            }
            catch (Exception paramView)
            {
              StringBuilder localStringBuilder;
              paramView = null;
              localObject2 = null;
              localObject3 = localObject5;
              continue;
            }
            Object localObject4;
            try
            {
              localObject3 = ((JSONObject)localObject3).optString("key");
            }
            catch (Exception localException2)
            {
              localObject7 = null;
              localObject4 = paramView;
              localObject5 = localObject2;
              paramView = (View)localObject7;
              localObject2 = localObject4;
              localObject4 = localObject5;
              continue;
            }
            try
            {
              localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
              localObject7 = new nug();
              ((nug)localObject7).a = 3;
              ((nug)localObject7).f = 1;
              localObject7 = nud.a((nug)localObject7, this.a.a.message);
              ((nud)((QQAppInterface)localObject5).a(139)).a((nug)localObject7, null);
              Long.parseLong((String)localObject1);
              localObject5 = localObject3;
              localObject3 = localObject1;
              localObject1 = localObject5;
              localObject5 = paramView;
              if (paramView != null) {
                localObject5 = paramView.replace("\"", "").replace("\n", "");
              }
              if (!"3".equals(this.a.an)) {
                continue;
              }
              paramView = (ntw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(88);
              if (paramView == null) {
                break;
              }
              paramView.a(this.a, (Activity)localContext);
              return;
            }
            catch (Exception localException3)
            {
              Object localObject6 = localObject4;
              localObject4 = localObject2;
              localObject2 = paramView;
              paramView = localObject6;
            }
          }
          localObject3 = new JSONObject((String)localObject1);
          continue;
          localObject5 = paramView;
          paramView = (View)localObject2;
          localObject2 = localObject5;
        }
        localObject7 = new StringBuilder();
        localStringBuilder = ((StringBuilder)localObject7).append(str);
        if (str.contains("?")) {}
        for (paramView = "&view_id=";; paramView = "?view_id=")
        {
          localStringBuilder.append(paramView).append(String.valueOf(localObject5)).append("&ad_id=").append(String.valueOf(localObject3)).append("&trace_id=").append(String.valueOf(localObject2));
          localIntent.putExtra("url", ((StringBuilder)localObject7).toString());
          localIntent.putExtra("big_brother_source_key", "biz_src_gzh_qqgw");
          localContext.startActivity(localIntent);
          return;
        }
        paramView = azqe.a();
        if (paramView.a()) {
          break;
        }
      } while (!(this.a.a instanceof StructMsgForGeneralShare));
      paramView = (StructMsgForGeneralShare)this.a.a;
      this.a.a(localContext, paramView, 0L);
      return;
      if (!paramView.a(localContext, 3, this.a.a.uinType)) {
        break;
      }
    } while (!(this.a.a instanceof StructMsgForGeneralShare));
    paramView = (StructMsgForGeneralShare)this.a.a;
    this.a.a(localContext, paramView, 0L);
    return;
    if (!ndd.a(localContext))
    {
      QQToast.a(localContext, 2131692397, 0).a();
      return;
    }
    this.a.a(localContext, (StructMsgForGeneralShare)this.a.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvr
 * JD-Core Version:    0.7.0.1
 */