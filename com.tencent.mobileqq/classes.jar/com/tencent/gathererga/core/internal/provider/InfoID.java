package com.tencent.gathererga.core.internal.provider;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface InfoID
{
  int id() default 0;
  
  String[] permissions() default {};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.InfoID
 * JD-Core Version:    0.7.0.1
 */