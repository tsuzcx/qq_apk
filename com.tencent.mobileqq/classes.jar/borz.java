class borz
  implements bpdr<Boolean, bpdw>
{
  borz(borx paramborx) {}
  
  public Void a(Boolean paramBoolean, bpdw parambpdw)
  {
    if ((!paramBoolean.booleanValue()) || (parambpdw == null) || (parambpdw.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      ykq.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    ykq.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(parambpdw.jdField_a_of_type_Int));
    if (parambpdw.jdField_a_of_type_Int >= this.a.a.length)
    {
      ykq.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(parambpdw.jdField_a_of_type_Int) });
      return null;
    }
    ykq.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(parambpdw.jdField_a_of_type_Int));
    this.a.a[parambpdw.jdField_a_of_type_Int] = bosa.a(this.a.a[parambpdw.jdField_a_of_type_Int], parambpdw.jdField_a_of_type_AndroidGraphicsBitmap);
    this.a.a[parambpdw.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = parambpdw.jdField_a_of_type_JavaLangString;
    this.a.k();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     borz
 * JD-Core Version:    0.7.0.1
 */