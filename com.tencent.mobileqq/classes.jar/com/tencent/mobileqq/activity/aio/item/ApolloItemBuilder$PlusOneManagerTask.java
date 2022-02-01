package com.tencent.mobileqq.activity.aio.item;

import agnq;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import java.lang.ref.WeakReference;

class ApolloItemBuilder$PlusOneManagerTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  WeakReference<agnq> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  WeakReference<ApolloItemBuilder> b;
  WeakReference<MessageForApollo> c;
  
  public ApolloItemBuilder$PlusOneManagerTask(ApolloItemBuilder paramApolloItemBuilder, agnq paramagnq, MessageForApollo paramMessageForApollo, int paramInt)
  {
    this.b = new WeakReference(paramApolloItemBuilder);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramagnq);
    this.c = new WeakReference(paramMessageForApollo);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    ApolloItemBuilder localApolloItemBuilder = (ApolloItemBuilder)this.b.get();
    agnq localagnq = (agnq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    MessageForApollo localMessageForApollo = (MessageForApollo)this.c.get();
    if ((localApolloItemBuilder == null) || (localagnq == null) || (localMessageForApollo == null)) {
      break label45;
    }
    label45:
    while (!(localagnq instanceof agnq)) {
      return;
    }
    if (this.jdField_a_of_type_Int == 0) {
      if ((!(localagnq.c.getContext() instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_Boolean) && (!localApolloItemBuilder.a.isUpComingPrevious))
      {
        if (!localMessageForApollo.isSend()) {
          break label165;
        }
        localagnq.c.setVisibility(0);
        localagnq.d.setVisibility(8);
      }
    }
    for (;;)
    {
      ApolloItemBuilder.a(localApolloItemBuilder, true);
      if ((this.jdField_a_of_type_Int != 1) || (ApolloItemBuilder.a(localApolloItemBuilder) != localMessageForApollo.uniseq)) {
        break;
      }
      localagnq.c.setVisibility(8);
      localagnq.d.setVisibility(8);
      ApolloItemBuilder.a(localApolloItemBuilder, 0L);
      return;
      label165:
      localagnq.c.setVisibility(8);
      localagnq.d.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.PlusOneManagerTask
 * JD-Core Version:    0.7.0.1
 */