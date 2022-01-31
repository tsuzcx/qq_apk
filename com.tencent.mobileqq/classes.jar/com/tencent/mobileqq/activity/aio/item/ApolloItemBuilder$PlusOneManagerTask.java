package com.tencent.mobileqq.activity.aio.item;

import afdm;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.data.MessageForApollo;
import java.lang.ref.WeakReference;

class ApolloItemBuilder$PlusOneManagerTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  WeakReference<afdm> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  WeakReference<ApolloItemBuilder> b;
  WeakReference<MessageForApollo> c;
  
  public ApolloItemBuilder$PlusOneManagerTask(ApolloItemBuilder paramApolloItemBuilder, afdm paramafdm, MessageForApollo paramMessageForApollo, int paramInt)
  {
    this.b = new WeakReference(paramApolloItemBuilder);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramafdm);
    this.c = new WeakReference(paramMessageForApollo);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    ApolloItemBuilder localApolloItemBuilder = (ApolloItemBuilder)this.b.get();
    afdm localafdm = (afdm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    MessageForApollo localMessageForApollo = (MessageForApollo)this.c.get();
    if ((localApolloItemBuilder == null) || (localafdm == null) || (localMessageForApollo == null)) {
      break label45;
    }
    label45:
    while (!(localafdm instanceof afdm)) {
      return;
    }
    if (this.jdField_a_of_type_Int == 0) {
      if ((!(localafdm.c.getContext() instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_Boolean))
      {
        if (!localMessageForApollo.isSend()) {
          break label155;
        }
        localafdm.c.setVisibility(0);
        localafdm.d.setVisibility(8);
      }
    }
    for (;;)
    {
      ApolloItemBuilder.a(localApolloItemBuilder, true);
      if ((this.jdField_a_of_type_Int != 1) || (ApolloItemBuilder.a(localApolloItemBuilder) != localMessageForApollo.uniseq)) {
        break;
      }
      localafdm.c.setVisibility(8);
      localafdm.d.setVisibility(8);
      ApolloItemBuilder.a(localApolloItemBuilder, 0L);
      return;
      label155:
      localafdm.c.setVisibility(8);
      localafdm.d.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.PlusOneManagerTask
 * JD-Core Version:    0.7.0.1
 */