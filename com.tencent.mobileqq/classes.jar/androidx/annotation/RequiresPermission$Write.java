package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
public @interface RequiresPermission$Write
{
  RequiresPermission value() default @RequiresPermission;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.annotation.RequiresPermission.Write
 * JD-Core Version:    0.7.0.1
 */