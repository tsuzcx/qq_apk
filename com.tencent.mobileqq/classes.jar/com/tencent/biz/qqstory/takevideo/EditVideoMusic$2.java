package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import xan;
import xbx;
import xoe;
import xof;

class EditVideoMusic$2
  implements Runnable
{
  EditVideoMusic$2(EditVideoMusic paramEditVideoMusic) {}
  
  public void run()
  {
    if ((!this.this$0.c) && (this.this$0.d))
    {
      this.this$0.c = true;
      localObject = this.this$0.a(xbx.class);
      if (localObject == null) {
        break label145;
      }
    }
    label145:
    for (Object localObject = ((xbx)localObject).a(this.this$0.a.a());; localObject = null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((xoe)localObject).a.a == 1) {
          bool1 = true;
        }
      }
      new EditVideoMusicDialog(this.this$0.a(), this.this$0, this.this$0.b, (int)this.this$0.a.a(this.this$0.a.a()), this.this$0.a.a, true, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic.2
 * JD-Core Version:    0.7.0.1
 */