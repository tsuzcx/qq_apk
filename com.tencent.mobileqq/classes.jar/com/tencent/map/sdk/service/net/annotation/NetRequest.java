package com.tencent.map.sdk.service.net.annotation;

import com.tencent.map.tools.net.NetMethod;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface NetRequest
{
  String constQuery() default "";
  
  NetHead head() default @NetHead;
  
  NetMethod method();
  
  String path() default "";
  
  String[] queryKeys() default {};
  
  int retry() default 1;
  
  String userAgent() default "androidsdk";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.service.net.annotation.NetRequest
 * JD-Core Version:    0.7.0.1
 */