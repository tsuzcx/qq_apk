package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
public @interface GuardedBy
{
  String value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.annotation.GuardedBy
 * JD-Core Version:    0.7.0.1
 */