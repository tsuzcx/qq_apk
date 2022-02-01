class bpai
  implements bpqw<Boolean, bprb>
{
  bpai(bpag parambpag) {}
  
  public Void a(Boolean paramBoolean, bprb parambprb)
  {
    if ((!paramBoolean.booleanValue()) || (parambprb == null) || (parambprb.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      yqp.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    yqp.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(parambprb.jdField_a_of_type_Int));
    if (parambprb.jdField_a_of_type_Int >= this.a.a.length)
    {
      yqp.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(parambprb.jdField_a_of_type_Int) });
      return null;
    }
    yqp.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(parambprb.jdField_a_of_type_Int));
    this.a.a[parambprb.jdField_a_of_type_Int] = bpaj.a(this.a.a[parambprb.jdField_a_of_type_Int], parambprb.jdField_a_of_type_AndroidGraphicsBitmap);
    this.a.a[parambprb.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = parambprb.jdField_a_of_type_JavaLangString;
    this.a.j();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpai
 * JD-Core Version:    0.7.0.1
 */