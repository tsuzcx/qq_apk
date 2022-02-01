package com.tencent.biz.qqstory.takevideo.slideshow;

class Image2Video$1
  implements Image2Video.Image2VideoListener
{
  public void a(ResultInfo paramResultInfo)
  {
    synchronized (this.a)
    {
      this.a.a(paramResultInfo);
      this.a.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.1
 * JD-Core Version:    0.7.0.1
 */