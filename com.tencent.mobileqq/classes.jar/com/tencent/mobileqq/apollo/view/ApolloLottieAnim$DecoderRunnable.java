package com.tencent.mobileqq.apollo.view;

import java.lang.ref.WeakReference;

class ApolloLottieAnim$DecoderRunnable
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<ApolloLottieAnim> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public void a(ApolloLottieAnim paramApolloLottieAnim, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloLottieAnim);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ApolloLottieAnim.a((ApolloLottieAnim)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLottieAnim.DecoderRunnable
 * JD-Core Version:    0.7.0.1
 */