package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface InspectableProperty
{
  int attributeId() default 0;
  
  InspectableProperty.EnumEntry[] enumMapping() default {};
  
  InspectableProperty.FlagEntry[] flagMapping() default {};
  
  boolean hasAttributeId() default true;
  
  String name() default "";
  
  InspectableProperty.ValueType valueType() default InspectableProperty.ValueType.INFERRED;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.annotation.InspectableProperty
 * JD-Core Version:    0.7.0.1
 */