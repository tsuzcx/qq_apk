package com.tencent.image_picker.imagepicker.features;

import java.util.List;

class e$2$1
  implements Runnable
{
  e$2$1(e.2 param2, List paramList1, List paramList2) {}
  
  public void run()
  {
    ((g)this.c.a.d()).a(this.a, this.b);
    List localList = this.b;
    boolean bool;
    if (localList != null) {
      bool = localList.isEmpty();
    } else {
      bool = this.a.isEmpty();
    }
    if (bool)
    {
      ((g)this.c.a.d()).a();
      return;
    }
    ((g)this.c.a.d()).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.features.e.2.1
 * JD-Core Version:    0.7.0.1
 */