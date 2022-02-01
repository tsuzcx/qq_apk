package com.squareup.wire;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/WireRpc;", "", "path", "", "requestAdapter", "responseAdapter", "()Ljava/lang/String;", "wire-runtime"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.FUNCTION})
public @interface WireRpc
{
  String path();
  
  String requestAdapter();
  
  String responseAdapter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.WireRpc
 * JD-Core Version:    0.7.0.1
 */