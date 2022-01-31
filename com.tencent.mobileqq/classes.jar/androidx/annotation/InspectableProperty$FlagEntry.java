package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface InspectableProperty$FlagEntry
{
  int mask() default 0;
  
  String name();
  
  int target();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.annotation.InspectableProperty.FlagEntry
 * JD-Core Version:    0.7.0.1
 */