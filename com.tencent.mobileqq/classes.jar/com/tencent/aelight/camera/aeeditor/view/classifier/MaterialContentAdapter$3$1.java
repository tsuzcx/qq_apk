package com.tencent.aelight.camera.aeeditor.view.classifier;

class MaterialContentAdapter$3$1
  implements Runnable
{
  MaterialContentAdapter$3$1(MaterialContentAdapter.3 param3, ApplyMaterialTask.Status paramStatus) {}
  
  public void run()
  {
    if (this.b.b == ApplyMaterialTask.Status.FAILED)
    {
      MaterialContentAdapter.b(this.b.d, this.b.c, this.b.a);
      return;
    }
    int i = MaterialContentAdapter.5.a[this.a.ordinal()];
    if (i != 2)
    {
      if (i != 3) {
        return;
      }
      MaterialContentAdapter.b(this.b.d, this.b.c, this.b.a);
      return;
    }
    if (MaterialContentAdapter.c(this.b.d) == this.b.c)
    {
      ApplyMaterialTaskHelper.a("onApplyMaterialLocal", this.b.a, "start");
      this.b.d.a(this.b.c, true);
      MaterialContentAdapter.b(this.b.d).e(this.b.c, this.b.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */