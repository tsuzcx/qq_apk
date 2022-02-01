import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/VasApngFactory$Options;", "", "()V", "autoScale", "", "getAutoScale", "()Z", "setAutoScale", "(Z)V", "extraInfo", "Landroid/os/Bundle;", "getExtraInfo", "()Landroid/os/Bundle;", "setExtraInfo", "(Landroid/os/Bundle;)V", "loadListener", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "getLoadListener", "()Lcom/tencent/image/URLDrawable$URLDrawableListener;", "setLoadListener", "(Lcom/tencent/image/URLDrawable$URLDrawableListener;)V", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "setLoadingDrawable", "(Landroid/graphics/drawable/Drawable;)V", "loop", "", "getLoop", "()I", "setLoop", "(I)V", "requestHeight", "getRequestHeight", "setRequestHeight", "requestWidth", "getRequestWidth", "setRequestWidth", "tagId", "", "getTagId", "()[I", "setTagId", "([I)V", "useCache", "getUseCache", "setUseCache", "useUnFinishedCache", "getUseUnFinishedCache", "setUseUnFinishedCache", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhop
{
  private int jdField_a_of_type_Int;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawableHelper.TRANSPARENT;
  @NotNull
  private Bundle jdField_a_of_type_AndroidOsBundle = new Bundle();
  @NotNull
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = (URLDrawable.URLDrawableListener)new URLDrawableHelper.Adapter();
  private boolean jdField_a_of_type_Boolean = true;
  @NotNull
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  @NotNull
  public final Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  @NotNull
  public final URLDrawable.URLDrawableListener a()
  {
    return this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public final void a(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "<set-?>");
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public final int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public final boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public final int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public final void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public final boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhop
 * JD-Core Version:    0.7.0.1
 */