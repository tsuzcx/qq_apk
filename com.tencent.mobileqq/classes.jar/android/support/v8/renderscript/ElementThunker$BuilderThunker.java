package android.support.v8.renderscript;

import android.renderscript.Element.Builder;

class ElementThunker$BuilderThunker
{
  Element.Builder mN;
  
  public ElementThunker$BuilderThunker(RenderScript paramRenderScript)
  {
    this.mN = new Element.Builder(((RenderScriptThunker)paramRenderScript).mN);
  }
  
  public void add(Element paramElement, String paramString, int paramInt)
  {
    paramElement = (ElementThunker)paramElement;
    this.mN.add(paramElement.mN, paramString, paramInt);
  }
  
  public Element create(RenderScript paramRenderScript)
  {
    return new ElementThunker(paramRenderScript, this.mN.create());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.ElementThunker.BuilderThunker
 * JD-Core Version:    0.7.0.1
 */