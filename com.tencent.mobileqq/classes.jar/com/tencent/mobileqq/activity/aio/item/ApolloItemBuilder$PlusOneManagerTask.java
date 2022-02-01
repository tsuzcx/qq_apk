package com.tencent.mobileqq.activity.aio.item;

import agyp;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import java.lang.ref.WeakReference;

class ApolloItemBuilder$PlusOneManagerTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  WeakReference<agyp> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  WeakReference<ApolloItemBuilder> b;
  WeakReference<MessageForApollo> c;
  
  public ApolloItemBuilder$PlusOneManagerTask(ApolloItemBuilder paramApolloItemBuilder, agyp paramagyp, MessageForApollo paramMessageForApollo, int paramInt)
  {
    this.b = new WeakReference(paramApolloItemBuilder);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramagyp);
    this.c = new WeakReference(paramMessageForApollo);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    ApolloItemBuilder localApolloItemBuilder = (ApolloItemBuilder)this.b.get();
    agyp localagyp = (agyp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    MessageForApollo localMessageForApollo = (MessageForApollo)this.c.get();
    if ((localApolloItemBuilder == null) || (localagyp == null) || (localMessageForApollo == null)) {
      break label45;
    }
    label45:
    while (!(localagyp instanceof agyp)) {
      return;
    }
    if (this.jdField_a_of_type_Int == 0) {
      if ((!(localagyp.c.getContext() instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_Boolean) && (!localApolloItemBuilder.a.n))
      {
        if (!localMessageForApollo.isSend()) {
          break label165;
        }
        localagyp.c.setVisibility(0);
        localagyp.d.setVisibility(8);
      }
    }
    for (;;)
    {
      ApolloItemBuilder.a(localApolloItemBuilder, true);
      if ((this.jdField_a_of_type_Int != 1) || (ApolloItemBuilder.a(localApolloItemBuilder) != localMessageForApollo.uniseq)) {
        break;
      }
      localagyp.c.setVisibility(8);
      localagyp.d.setVisibility(8);
      ApolloItemBuilder.a(localApolloItemBuilder, 0L);
      return;
      label165:
      localagyp.c.setVisibility(8);
      localagyp.d.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.PlusOneManagerTask
 * JD-Core Version:    0.7.0.1
 */