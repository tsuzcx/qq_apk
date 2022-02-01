package com.tencent.biz.pubaccount.qqnews;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/biz/pubaccount/qqnews/QQNewsHippyFragment$updateUnreadNumOnTitleBar$1$1"}, k=3, mv={1, 1, 16})
final class QQNewsHippyFragment$updateUnreadNumOnTitleBar$$inlined$let$lambda$1
  implements Runnable
{
  QQNewsHippyFragment$updateUnreadNumOnTitleBar$$inlined$let$lambda$1(Ref.ObjectRef paramObjectRef, QQNewsHippyFragment paramQQNewsHippyFragment, QQAppInterface paramQQAppInterface) {}
  
  public final void run()
  {
    Object localObject;
    if (QQNewsHippyFragment.b(this.this$0))
    {
      localObject = QQNewsHippyFragment.c(this.this$0);
      if (localObject != null)
      {
        localObject = (TextView)((NavBarAIO)localObject).findViewById(2131448219);
        if (localObject != null)
        {
          if (TextUtils.isEmpty((CharSequence)this.a.element))
          {
            ((TextView)localObject).setVisibility(8);
            return;
          }
          ((TextView)localObject).setText((CharSequence)this.a.element);
          ((TextView)localObject).setVisibility(0);
        }
      }
    }
    else
    {
      localObject = QQNewsHippyFragment.c(this.this$0);
      if (localObject != null)
      {
        localObject = (TextView)((NavBarAIO)localObject).findViewById(2131436218);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.a.element);
        }
      }
      localObject = QQNewsHippyFragment.c(this.this$0);
      if (localObject != null) {
        ((NavBarAIO)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.qqnews.QQNewsHippyFragment.updateUnreadNumOnTitleBar..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */