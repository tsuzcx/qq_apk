package com.squareup.wire;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/WireField;", "", "tag", "", "keyAdapter", "", "adapter", "label", "Lcom/squareup/wire/WireField$Label;", "redacted", "", "declaredName", "jsonName", "()Ljava/lang/String;", "()Lcom/squareup/wire/WireField$Label;", "()Z", "()I", "Label", "wire-runtime"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.FIELD})
public @interface WireField
{
  String adapter();
  
  String declaredName() default "";
  
  String jsonName() default "";
  
  String keyAdapter() default "";
  
  WireField.Label label() default WireField.Label.OPTIONAL;
  
  boolean redacted() default false;
  
  int tag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.WireField
 * JD-Core Version:    0.7.0.1
 */