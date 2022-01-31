import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type.Builder;
import android.support.annotation.RequiresApi;

public class asjp
{
  private Allocation jdField_a_of_type_AndroidRenderscriptAllocation;
  private RenderScript jdField_a_of_type_AndroidRenderscriptRenderScript;
  private ScriptIntrinsicYuvToRGB jdField_a_of_type_AndroidRenderscriptScriptIntrinsicYuvToRGB;
  private Type.Builder jdField_a_of_type_AndroidRenderscriptType$Builder;
  private Allocation jdField_b_of_type_AndroidRenderscriptAllocation;
  private Type.Builder jdField_b_of_type_AndroidRenderscriptType$Builder;
  
  @RequiresApi(api=17)
  public asjp(Context paramContext)
  {
    this.jdField_a_of_type_AndroidRenderscriptRenderScript = RenderScript.create(paramContext);
    this.jdField_a_of_type_AndroidRenderscriptScriptIntrinsicYuvToRGB = ScriptIntrinsicYuvToRGB.create(this.jdField_a_of_type_AndroidRenderscriptRenderScript, Element.U8_4(this.jdField_a_of_type_AndroidRenderscriptRenderScript));
  }
  
  @RequiresApi(api=17)
  public Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidRenderscriptType$Builder == null)
    {
      this.jdField_a_of_type_AndroidRenderscriptType$Builder = new Type.Builder(this.jdField_a_of_type_AndroidRenderscriptRenderScript, Element.U8(this.jdField_a_of_type_AndroidRenderscriptRenderScript)).setX(paramArrayOfByte.length);
      this.jdField_a_of_type_AndroidRenderscriptAllocation = Allocation.createTyped(this.jdField_a_of_type_AndroidRenderscriptRenderScript, this.jdField_a_of_type_AndroidRenderscriptType$Builder.create(), 1);
      this.jdField_b_of_type_AndroidRenderscriptType$Builder = new Type.Builder(this.jdField_a_of_type_AndroidRenderscriptRenderScript, Element.RGBA_8888(this.jdField_a_of_type_AndroidRenderscriptRenderScript)).setX(paramInt1).setY(paramInt2);
      this.jdField_b_of_type_AndroidRenderscriptAllocation = Allocation.createTyped(this.jdField_a_of_type_AndroidRenderscriptRenderScript, this.jdField_b_of_type_AndroidRenderscriptType$Builder.create(), 1);
    }
    this.jdField_a_of_type_AndroidRenderscriptAllocation.copyFrom(paramArrayOfByte);
    this.jdField_a_of_type_AndroidRenderscriptScriptIntrinsicYuvToRGB.setInput(this.jdField_a_of_type_AndroidRenderscriptAllocation);
    this.jdField_a_of_type_AndroidRenderscriptScriptIntrinsicYuvToRGB.forEach(this.jdField_b_of_type_AndroidRenderscriptAllocation);
    paramArrayOfByte = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.jdField_b_of_type_AndroidRenderscriptAllocation.copyTo(paramArrayOfByte);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asjp
 * JD-Core Version:    0.7.0.1
 */